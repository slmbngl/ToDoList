package com.mehmetsalimbingol.todolist

data class Item(
    val title: String,
    val description: String,
    var isChecked: Boolean = false
)

