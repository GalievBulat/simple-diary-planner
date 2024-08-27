package com.example.simple_diary_planner.feature_calendar.presentation

data class CalendarState(
    val selectedDate: Long = System.currentTimeMillis(),
    val tasks: List<com.example.core_model.Task> = emptyList(),
)