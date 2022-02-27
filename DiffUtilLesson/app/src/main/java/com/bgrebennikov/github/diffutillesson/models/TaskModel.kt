package com.bgrebennikov.github.diffutillesson.models

data class TaskModel(
    val name: String,
    val isDone: Boolean
) : ListItem{
    override val itemId: Int
        get() = name.hashCode()
}
