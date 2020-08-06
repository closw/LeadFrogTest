package de.leadfrog.app_new.presentation.feature.contacts.adapters

import androidx.recyclerview.widget.RecyclerView
import de.leadfrog.app_new.databinding.ItemContactBinding
import de.leadfrog.app_new.presentation.base.ItemClickListener
import de.leadfrog.app_new.presentation.viewmodel.ContactModel

class ContactViewHolder (val binding: ItemContactBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(contactModel : ContactModel, listener: ItemClickListener<ContactModel>){
        with(binding) {
            root.setOnClickListener { contactModel.let { contact -> listener.click(contact) } }
            model = contactModel
            executePendingBindings()
        }
    }

}