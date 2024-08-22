package com.aman.contactlistapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.aman.contactlistapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var viewModel : ContactsViewModel
    private lateinit var contactsAdapter: ContactsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.floatingActionButton.setOnClickListener{
            val intent = Intent(this , CreateContact::class.java)
            startActivity(intent)
        }

        viewModel = ViewModelProvider(this)[ContactsViewModel::class.java]

        viewModel.getAllContacts().observe(this) { list ->
            binding.recyclerView.layoutManager = LinearLayoutManager(applicationContext)
            contactsAdapter = ContactsAdapter(this,list)
            binding.recyclerView.adapter = contactsAdapter

        }
    }
}