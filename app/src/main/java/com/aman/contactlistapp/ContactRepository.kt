package com.aman.contactlistapp

import androidx.lifecycle.LiveData

class ContactRepository(private val dao: ContactsDao) {

    fun getAllContacts():LiveData<List<Contacts>>{
        return dao.getAllContacts()
    }

    fun addContact(contact: Contacts){
        dao.insertContact(contact)
    }

    fun deleteContact(contact: Contacts){
        dao.deleteContact(contact)
    }
}