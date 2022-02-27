package com.bgrebennikov.github.diffexample.adapters

import androidx.recyclerview.widget.DiffUtil
import com.bgrebennikov.github.diffexample.models.PersonModel

class NamesDiffCallback(
    private val oldList: List<PersonModel>,
    private val newList: List<PersonModel>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }


}