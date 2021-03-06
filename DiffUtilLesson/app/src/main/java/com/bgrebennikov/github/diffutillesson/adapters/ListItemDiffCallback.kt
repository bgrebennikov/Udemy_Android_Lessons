package com.bgrebennikov.github.diffutillesson.adapters

import androidx.recyclerview.widget.DiffUtil
import com.bgrebennikov.github.diffutillesson.models.TaskModel

class ListItemDiffCallback(
    private val oldList: List<TaskModel>,
    private val newList: List<TaskModel>
) : DiffUtil.Callback() {



    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].itemId == newList[newItemPosition].itemId
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}