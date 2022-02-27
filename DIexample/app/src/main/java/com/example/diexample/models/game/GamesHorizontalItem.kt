package com.example.diexample.models.game

import com.example.diexample.models.base.ListItem

data class GamesHorizontalItem(
    val title : String,
    val games: List<ListItem>,
) : ListItem {
    override val itemId: Long
        get() = title.hashCode().toLong()
}