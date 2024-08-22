package com.aman.contactlistapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class ContactsViewModel(application: Application): AndroidViewModel(application) {

    private val repository:ContactRepository

    init {
        val dao = ContactDatabase.getDatabaseInstance(application).ContactsDao()
        repository = ContactRepository(dao)
    }

    fun addContacts(contact: Contacts){
        repository.addContact(contact)
    }

    fun deleteContact(contact: Contacts){
        repository.deleteContact(contact)
    }

    fun getAllContacts(): LiveData<List<Contacts>> = repository.getAllContacts()
}