package com.aman.contactlistapp

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aman.contactlistapp.databinding.ContactsLayoutBinding


class ContactsAdapter(val context: Context, val list: List<Contacts>):RecyclerView.Adapter<ContactsAdapter.ViewHolder>() {
    private val dao = ContactDatabase.getDatabaseInstance(context).ContactsDao()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsAdapter.ViewHolder {
        return ViewHolder(
            ContactsLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.contactName.text = list[position].name
        holder.binding.contactNumber.text = list[position].number

        holder.binding.deleteButton.setOnClickListener {
            dao.deleteContact(list[position])

        }

        holder.itemView.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL, Uri.parse(""+list[position].number))
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

     class ViewHolder(val binding:ContactsLayoutBinding):RecyclerView.ViewHolder(binding.root){

    }
}