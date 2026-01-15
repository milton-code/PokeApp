package com.proyecto.pokeapp.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.proyecto.pokeapp.R
import com.proyecto.pokeapp.data.models.Ability

class PokeAbilityAdapter(private val onItemClicked: (Ability) -> Unit) : ListAdapter<Ability, PokeAbilityAdapter.ViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.itemNumber.text = item.name
        holder.itemView.setOnClickListener { 
            onItemClicked(item)
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemNumber: TextView = view.findViewById(R.id.item_number)
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Ability>() {
            override fun areItemsTheSame(oldItem: Ability, newItem: Ability): Boolean {
                return oldItem.url == newItem.url
            }

            override fun areContentsTheSame(oldItem: Ability, newItem: Ability): Boolean {
                return oldItem == newItem
            }
        }
    }
}