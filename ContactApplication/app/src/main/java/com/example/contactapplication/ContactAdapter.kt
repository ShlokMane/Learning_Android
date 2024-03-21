package com.example.contactapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter(private val listOfContacts: List<Contact>) :
    RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val contactIV: ImageView = itemView.findViewById(R.id.userIV)
        val contactName: TextView = itemView.findViewById(R.id.userNameTV)
        val contactPhoneNumber: TextView = itemView.findViewById(R.id.userPhoneNumberTV)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_contact, parent, false)
        return ContactViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listOfContacts.size
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val currentContact = listOfContacts[position]
        holder.contactName.text = currentContact.name
        holder.contactPhoneNumber.text = currentContact.phoneNumber
        holder.contactIV.setImageURI(currentContact.image)
    }
}
