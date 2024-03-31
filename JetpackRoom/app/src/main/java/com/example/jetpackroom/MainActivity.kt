package com.example.jetpackroom

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.jetpackroom.db.Note
import com.example.jetpackroom.db.NoteDatabase
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(), NotesAdapter.NoteRecyclerViewClickListener {

    private lateinit var repo: Repo
    private lateinit var notesViewModel: NotesViewModel
    private lateinit var notesViewModelFactory: NotesViewModelFactory
    private lateinit var notesDatabase: NoteDatabase
    private lateinit var notesAdapter: NotesAdapter
    private lateinit var notesRV: RecyclerView
    private lateinit var floatingActionButton: FloatingActionButton
    private lateinit var dialog: Dialog
    private lateinit var noteNameET: EditText
    private lateinit var noteDescription: EditText
    private lateinit var saveNoteButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()

        notesViewModel.getAllNotes().observe(this) {
            notesAdapter = NotesAdapter(it, this)
            notesRV.adapter = notesAdapter
            notesRV.layoutManager = LinearLayoutManager(this)
        }


    }

    private fun onClickFAB() {
        floatingActionButton.setOnClickListener {
            openDialog(newNoteCreation = true, null)
        }
    }

    private fun openDialog(newNoteCreation: Boolean, oldNote: Note?) {
        dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.layout_dialog)

        noteNameET = dialog.findViewById(R.id.note_name_et)
        noteDescription = dialog.findViewById(R.id.note_desc_et)
        if(!newNoteCreation) {
            noteNameET.setText(oldNote!!.noteName)
            noteDescription.setText(oldNote!!.noteContent)
        }
        saveNoteButton = dialog.findViewById(R.id.save_note_button)

        saveNoteButton.setOnClickListener {
            val note = Note(
                noteName = noteNameET.text.toString(),
                noteContent = noteDescription.text.toString()
            )
            if(newNoteCreation) {
                notesViewModel.insert(note)
            }  else {
                oldNote!!.noteName = noteNameET.text.toString()
                oldNote.noteContent = noteDescription.text.toString()
                notesViewModel.update(oldNote)
            }
            dialog.dismiss()
        }
        dialog.show()
    }

    private fun init() {
        notesDatabase = NoteDatabase(this)
        repo = Repo(notesDatabase.getNoteDao())
        notesViewModelFactory = NotesViewModelFactory(repo)
        notesViewModel = ViewModelProvider(this, notesViewModelFactory,).get(NotesViewModel::class.java)
        notesRV = findViewById(R.id.notesRV)
        floatingActionButton = findViewById(R.id.add_note_fab)
        onClickFAB()
    }

    override fun updateNote(note: Note) {
        openDialog(newNoteCreation = false, note)
        notesViewModel.update(note)
    }

    override fun deleteNote(note: Note) {
        notesViewModel.delete(note)
    }
}