package de.leadfrog.app_new.presentation.feature.diagrams.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import de.leadfrog.app_new.R
import de.leadfrog.app_new.presentation.base.ItemClickListener
import de.leadfrog.app_new.presentation.viewmodel.DiagramModel

class DiagramsAdapter (): RecyclerView.Adapter<DiagramViewHolder>()  {
    var diagramsList : MutableList<DiagramModel> = mutableListOf()
    lateinit var listener : ItemClickListener<DiagramModel>

    fun setList(list: MutableList<DiagramModel>){
        diagramsList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiagramViewHolder = DiagramViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_diagram, parent, false), listener)

    override fun getItemCount(): Int = diagramsList.size


    override fun onBindViewHolder(holder: DiagramViewHolder, position: Int) {
       holder.bind(diagramsList[position])
    }
}