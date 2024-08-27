package com.example.core_model

data class Task(
    val id: Int,
    val name: String,
    val dateStart: Long,
    val dateFinish: Long,
    val description: String
)
