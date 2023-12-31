package com.dicoding.synrgy4_challange.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.dicoding.synrgy4_challange.data.model.Note

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: Note)

    @Query("SELECT * FROM notes")
    fun getAll(): LiveData<List<Note>>

    @Update
    suspend fun update(note: Note)

    @Delete
    suspend fun delete(note: Note)
}