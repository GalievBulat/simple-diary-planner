package com.example.feature_task_detail.presentation

data class TaskDetailState(
    val task: com.example.core_model.Task? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)
