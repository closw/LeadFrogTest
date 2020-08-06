package de.leadfrog.app_new.presentation.feature.leads.adapters

import androidx.recyclerview.widget.RecyclerView
import de.leadfrog.app_new.databinding.ItemLeadBinding
import de.leadfrog.app_new.presentation.base.ItemClickListener
import de.leadfrog.app_new.presentation.viewmodel.ContactModel
import de.leadfrog.app_new.presentation.viewmodel.LeadModel

class LeadsViewHolder(val binding: ItemLeadBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(lead : LeadModel, listener : ItemClickListener<ContactModel>){
        with(binding) {
            model = lead
            binding.root.setOnClickListener { lead.contact?.let { it1 -> listener.click(it1) } }
            executePendingBindings()
        }
    }

}