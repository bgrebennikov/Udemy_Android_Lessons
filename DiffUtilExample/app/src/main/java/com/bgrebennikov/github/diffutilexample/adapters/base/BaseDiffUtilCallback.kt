package com.bgrebennikov.github.diffutilexample.adapters.base

import androidx.recyclerview.widget.DiffUtil
import com.bgrebennikov.github.diffutilexample.models.base.ListItem

class BaseDiffUtilCallback : DiffUtil.ItemCallback<ListItem>() {
    override fun areItemsTheSame(oldItem: ListItem, newItem: ListItem): Boolean {
        return oldItem.itemId == newItem.itemId
    }

    override fun areContentsTheSame(oldItem: ListItem, newItem: ListItem): Boolean {
        return oldItem.equals(newItem)
    }
}