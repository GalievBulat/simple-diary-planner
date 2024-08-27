package com.example.feature_calendar.repository

import com.example.core_data.model.TaskEntity
import javax.inject.Inject

class CalendarRepositoryImpl @Inject constructor(private val taskDao: com.example.core_data.room.TaskDao):
    CalendarRepository {

    override suspend fun getTasksForDate(startDate: Long, endDate: Long): List<TaskEntity> {
        return taskDao.getTasksForDate(startDate, endDate)
    }
}

