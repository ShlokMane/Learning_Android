package com.example.contactapplication

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ContactViewModel(private val repo: Repo) : ViewModel(){
    val listOfContactLiveData = MutableLiveData<List<Contact>>()

    init {
        getAllData()
    }
    fun getAllData() {
        val allContact = repo.getAllContact()
        listOfContactLiveData.value = allContact
        Log.i("HelloWorld", listOfContactLiveData.value.toString())
    }

    fun addContact(contact: Contact) {
        repo.addDataToContactList(contact)
        getAllData()
    }
}