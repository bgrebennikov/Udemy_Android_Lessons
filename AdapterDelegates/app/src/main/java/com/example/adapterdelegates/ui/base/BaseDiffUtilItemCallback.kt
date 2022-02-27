package com.example.adapterdelegates.ui.base

import androidx.recyclerview.widget.DiffUtil
import com.example.adapterdelegates.ui.adapters.models.types.ListItem

class BaseDiffUtilItemCallback : DiffUtil.ItemCallback<ListItem>() {
    override fun areItemsTheSame(oldItem: ListItem, newItem: ListItem): Boolean {
        return oldItem.itemId == newItem.itemId
    }

    override fun areContentsTheSame(oldItem: ListItem, newItem: ListItem): Boolean {
        return oldItem.equals(newItem)
    }
}