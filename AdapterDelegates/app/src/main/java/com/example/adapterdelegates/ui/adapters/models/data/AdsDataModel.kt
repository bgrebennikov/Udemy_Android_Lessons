package com.example.adapterdelegates.ui.adapters.models.data

import com.example.adapterdelegates.ui.adapters.models.types.ListItem

data class AdsDataModel(
    val id: Long,
    val title : String,
    val body : String
) : ListItem{
    override val itemId: Long
        get() = id.hashCode().toLong()
}
