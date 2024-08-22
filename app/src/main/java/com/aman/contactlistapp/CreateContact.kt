package com.aman.contactlistapp

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.aman.contactlistapp.databinding.ActivityCreateContactBinding


class CreateContact:AppCompatActivity() {

    private lateinit var binding: ActivityCreateContactBinding

    private val viewModel:ContactsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        binding = ActivityCreateContactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.save.setOnClickListener {
            createContact()
        }
    }

    private fun createContact() {
        val name = binding.etName.text.toString()
        val number = binding.etNumber.text.toString()

        val data = Contacts(null, name,number)

        viewModel.addContacts(data)

        Toast.makeText(this@CreateContact,"Saved Contact", Toast.LENGTH_LONG).show()

        startActivity(Intent(this@CreateContact,MainActivity::class.java))
    }
}