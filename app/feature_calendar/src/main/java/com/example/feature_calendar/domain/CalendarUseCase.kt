package com.example.feature_calendar.domain

import com.example.core_model.Task
import com.example.core_navigation.utils.TaskResult
import kotlinx.coroutines.flow.Flow

interface CalendarUseCase {
    suspend fun getTasksForDate(date: Long): Flow<TaskResult<List<Task>?>>
}