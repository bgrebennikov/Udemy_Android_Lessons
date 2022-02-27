package com.example.diexample.models.game

import com.example.diexample.models.base.ListItem

data class GameWideItem(
    val id: Long,
    val title: String,
    val image: String?
) : ListItem {
    override val itemId: Long
        get() = id
}
