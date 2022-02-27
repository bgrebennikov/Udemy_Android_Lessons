package com.bgrebennikov.github.diffutilexample.models

import com.bgrebennikov.github.diffutilexample.models.base.ListItem

data class PlacesHorizontalModel(
    val title: String,
    val places: List<ListItem>
) : ListItem{
    override val itemId: Long
        get() = this.title.hashCode().toLong()
}
