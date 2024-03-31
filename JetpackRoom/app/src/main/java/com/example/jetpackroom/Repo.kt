package com.example.jetpackroom

import com.example.jetpackroom.db.Dao
import com.example.jetpackroom.db.Note

class Repo(private val dao: Dao) {

    fun insert(note: Note) {
        dao.insert(note)
    }

    fun delete(note: Note) {
        dao.delete(note)
    }

    fun update(note: Note) {
        dao.update(note)
    }

    fun getAllNotes() = dao.getAllNotes()
}