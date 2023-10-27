package com.dicoding.synrgy4_challange.ui.addnote

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.dicoding.synrgy4_challange.data.AppDatabase
import com.dicoding.synrgy4_challange.data.model.Note
import com.dicoding.synrgy4_challange.databinding.ActivityAddBinding
import com.dicoding.synrgy4_challange.repository.NoteRepository
import com.dicoding.synrgy4_challange.viewmodel.NoteViewModel
import com.dicoding.synrgy4_challange.viewmodel.NoteViewModelFactory

class AddNoteActivity: AppCompatActivity() {

    private val binding by lazy {ActivityAddBinding.inflate(layoutInflater)}
    private lateinit var noteViewModel: NoteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupViewModel()

        binding.imgCheck.setOnClickListener {
            val title = binding.etTitle.text.toString()
            val description = binding.etDescription.text.toString()
            if (title.isNullOrEmpty() || description.isNullOrEmpty()) {
                Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show()
            } else {
                noteViewModel.insert(Note(null, title, description))
                Toast.makeText(this, "Note added", Toast.LENGTH_SHORT).show()
                finish()
            }
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