package com.example.feature_calendar.repository

import com.example.core_data.model.TaskEntity


interface CalendarRepository {
    suspend fun getTasksForDate(startDate: Long, endDate: Long): List<TaskEntity>
}