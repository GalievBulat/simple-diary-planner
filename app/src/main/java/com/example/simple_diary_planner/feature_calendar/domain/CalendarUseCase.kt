package com.example.simple_diary_planner.feature_calendar.domain

import com.example.simple_diary_planner.utils.TaskResult
import kotlinx.coroutines.flow.Flow

interface CalendarUseCase {
    suspend fun getTasksForDate(date: Long): Flow<TaskResult<List<com.example.core_model.Task>?>>
}