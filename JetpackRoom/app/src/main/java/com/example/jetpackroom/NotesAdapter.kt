package com.example.jetpackroom

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpackroom.db.Note

class NotesAdapter(private val listOfNotes: List<Note>, private val noteRecyclerViewClickListener: NoteRecyclerViewClickListener): RecyclerView.Adapter<NotesAdapter.NotesViewHolder>(){

    class NotesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val noteName: TextView = itemView.findViewById(R.id.text_note_name)
        val noteDescription: TextView = itemView.findViewById(R.id.text_note_content)
        val deleteImage: ImageView = itemView.findViewById(R.id.img_delete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_note, parent, false)
        return NotesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listOfNotes.size
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val currentNote = listOfNotes[position]
        holder.noteName.text = currentNote.noteName
        holder.noteDescription.text = currentNote.noteContent

        holder.itemView.setOnClickListener {
            noteRecyclerViewClickListener.updateNote(currentNote)
        }
        holder.deleteImage.setOnClickListener {
            noteRecyclerViewClickListener.deleteNote(currentNote)
        }
    }

    interface NoteRecyclerViewClickListener {
        fun updateNote(note: Note)
        fun deleteNote(note: Note)
    }

}