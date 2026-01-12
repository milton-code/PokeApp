package com.proyecto.pokeapp.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.proyecto.pokeapp.R
import com.proyecto.pokeapp.data.models.Ability

class ListAdapter(private val onItemClicked: (Ability) -> Unit) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    private var items: List<Ability> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.itemNumber.text = item.name
        holder.itemView.setOnClickListener { 
            onItemClicked(item)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
    
    fun submitList(newItems: List<Ability>) {
        items = newItems
        notifyDataSetChanged() // Notifica al RecyclerView que los datos han cambiado
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemNumber: TextView = view.findViewById(R.id.item_number)
    }
}