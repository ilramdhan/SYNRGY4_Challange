package com.dicoding.synrgy4_challange.ui.listnote

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.dicoding.synrgy4_challange.data.AppDatabase
import com.dicoding.synrgy4_challange.data.model.Note
import com.dicoding.synrgy4_challange.databinding.ActivityListBinding
import com.dicoding.synrgy4_challange.listener.OnNoteClickListener
import com.dicoding.synrgy4_challange.repository.NoteRepository
import com.dicoding.synrgy4_challange.ui.addnote.AddNoteActivity
import com.dicoding.synrgy4_challange.viewmodel.NoteViewModel
import com.dicoding.synrgy4_challange.viewmodel.NoteViewModelFactory

class ListNoteActivity : AppCompatActivity() {

    private val binding by lazy { ActivityListBinding.inflate(layoutInflater) }
    private lateinit var noteViewModel: NoteViewModel
    private lateinit var adapter: ListNoteAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupViewModel()

        adapter = ListNoteAdapter(applicationContext, object : OnNoteClickListener{
            override fun onDelete(note: Note) {
                noteViewModel.delete(note)
            }

            override fun onEdit(note: Note) {
                TODO("Not yet implemented")
            }


        })

        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = StaggeredGridLayoutManager(2, LinearLayout.VERTICAL)
        binding.recyclerView.adapter = adapter

        binding.floatingActionButton.setOnClickListener {
            val intent = Intent(this, AddNoteActivity::class.java)
            startActivity(intent)
        }

        noteViewModel.getAll().observe(this) {
            adapter.updateList(it)
        }
    }

    private fun setupViewModel() {
        val noteRepository = NoteRepository(AppDatabase.getInstance(this))
        val viewModelProviderFactory = NoteViewModelFactory(noteRepository)

        noteViewModel = ViewModelProvider(
            this,
            viewModelProviderFactory
        ).get(NoteViewModel::class.java)

    }
}