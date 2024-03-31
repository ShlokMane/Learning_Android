package com.example.jetpackroom.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notesTable")
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    var noteName: String,
    var noteContent: String,

    )
