package com.example.contactapplication

import android.util.Log

class Repo {
    val listOfContact = mutableListOf<Contact>()

    fun getAllContact() = listOfContact
    fun addDataToContactList(contact: Contact) {
        listOfContact.add(contact)
        Log.i("Yo", listOfContact.toString())
    }
}