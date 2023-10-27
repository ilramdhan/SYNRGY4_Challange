package com.dicoding.synrgy4_challange.listener

import com.dicoding.synrgy4_challange.data.model.Note

interface OnNoteClickListener {
    fun onDelete(note: Note)
    fun onEdit(note: Note)
}