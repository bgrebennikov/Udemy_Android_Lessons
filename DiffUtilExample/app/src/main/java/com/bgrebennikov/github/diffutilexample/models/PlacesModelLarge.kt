package com.bgrebennikov.github.diffutilexample.models

import com.bgrebennikov.github.diffutilexample.models.base.ListItem

data class PlacesModelLarge(
    val title: String
) : ListItem {
    override val itemId: Long
        get() = title.hashCode().toLong()
}

