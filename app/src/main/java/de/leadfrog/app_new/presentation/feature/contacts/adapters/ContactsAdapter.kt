package de.leadfrog.app_new.presentation.feature.contacts.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import de.leadfrog.app_new.databinding.ItemContactBinding
import de.leadfrog.app_new.presentation.base.ItemClickListener
import de.leadfrog.app_new.presentation.viewmodel.ContactModel


class ContactsAdapter() : RecyclerView.Adapter<ContactViewHolder>() {
    private lateinit var contactBinding : ItemContactBinding
    var contacts: MutableList<ContactModel> = mutableListOf()
    lateinit var listener : ItemClickListener<ContactModel>

    fun setList(contacts : MutableList<ContactModel>){
        this.contacts = contacts
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        contactBinding = ItemContactBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ContactViewHolder(contactBinding)
    }

    override fun getItemCount() = contacts.size

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.bind(contacts[position], listener)
    }
}