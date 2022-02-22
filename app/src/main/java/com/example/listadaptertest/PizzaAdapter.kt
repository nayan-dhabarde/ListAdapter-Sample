package com.example.listadaptertest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.listadaptertest.databinding.PizzaRowBinding

class PizzaAdapter(val diffCallback: DiffUtil.ItemCallback<Pizza>): ListAdapter<Pizza, PizzaViewHolder>(diffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzaViewHolder {
        val binding = PizzaRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PizzaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PizzaViewHolder, position: Int) {
        holder.binding.apply {
            tvName.text = getItem(position).name
            tvCheese.text = getItem(position).cheese
            tvVegNonVeg.text = if(getItem(position).veg == true) "Veg" else "Non-veg"
        }
    }

    fun submitAndUpdateList(list: List<Pizza>) {
        submitList(list.toMutableList())
    }
}

class PizzaViewHolder(var binding: PizzaRowBinding): RecyclerView.ViewHolder(binding.root)