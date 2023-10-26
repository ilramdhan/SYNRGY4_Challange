package com.dicoding.synrgy4_challange.repository

import com.dicoding.synrgy4_challange.data.AppDatabase
import com.dicoding.synrgy4_challange.data.model.Note

class NoteRepository(private val db: AppDatabase) {

    fun getAll() = db.noteDao().getAll()

    suspend fun insert(note: Note) {
        db.noteDao().insert(note)
    }

    suspend fun update(note: Note) {
        db.noteDao().update(note)
    }

    suspend fun delete(note: Note) {
        db.noteDao().delete(note)
    }


}