package com.example.feature_create_task.presentation

sealed class CreateTaskEvent {
    object TaskCreated : CreateTaskEvent()
    data class ShowError(val message: String) : CreateTaskEvent()
}
