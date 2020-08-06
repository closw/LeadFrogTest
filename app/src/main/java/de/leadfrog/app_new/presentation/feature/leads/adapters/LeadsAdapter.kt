package de.leadfrog.app_new.presentation.feature.leads.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import de.leadfrog.app_new.databinding.ItemLeadBinding
import de.leadfrog.app_new.presentation.base.ItemClickListener
import de.leadfrog.app_new.presentation.viewmodel.ContactModel
import de.leadfrog.app_new.presentation.viewmodel.LeadModel

class LeadsAdapter() : RecyclerView.Adapter<LeadsViewHolder>() {
    lateinit var leadBinding : ItemLeadBinding
    lateinit var listener: ItemClickListener<ContactModel>
    var leads : MutableList<LeadModel> = mutableListOf()

    fun setList(leads : MutableList<LeadModel>){
        this.leads = leads
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeadsViewHolder {
        leadBinding = ItemLeadBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return LeadsViewHolder(leadBinding)
    }

    override fun getItemCount() = leads.size

    override fun onBindViewHolder(holder: LeadsViewHolder, position: Int) {
        holder.bind(leads[position], listener )
    }
}