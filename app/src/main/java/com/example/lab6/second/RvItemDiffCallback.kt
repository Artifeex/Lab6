package com.example.lab6.second

import androidx.recyclerview.widget.DiffUtil

class RvItemDiffCallback: DiffUtil.ItemCallback<Task>() {

    override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean {
        return oldItem.description == newItem.description
    }
}