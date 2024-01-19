package com.deerangle.notion.data.model

data class TodoTask(
    val id: Int,
    val title: String,
    val description: String,
    val dueDate: String,
    val status: TaskStatus,
    val createdAt: String,
    val updatedAt: String,
    val tags: List<TaskTag>,
)
