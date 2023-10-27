package com.dicoding.synrgy4_challange.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class Note(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id")
    var id: Int?,
    @ColumnInfo("title")
    var title: String,
    @ColumnInfo("description")
    var description: String,
)
