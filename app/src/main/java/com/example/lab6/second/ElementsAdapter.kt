package com.example.lab6.second

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.lab6.databinding.RvItemBinding

class ElementsAdapter: ListAdapter<Task, ElementsAdapter.ElementViewHolder>(RvItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ElementViewHolder {
        val binding = RvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ElementViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ElementViewHolder, position: Int) {
        val rvItem = getItem(position)
        holder.binding.tvItemDesc.text = rvItem.description
    }

    inner class ElementViewHolder(
        val binding: RvItemBinding
    ): RecyclerView.ViewHolder(binding.root)

}