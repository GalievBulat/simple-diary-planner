package com.example.simple_diary_planner.feature_create_task.repository

import com.example.core_data.model.TaskEntity

interface CreateTaskRepository {
    suspend fun saveTask(taskEntity: TaskEntity)
    suspend fun isTimeAvailable(task: TaskEntity): Boolean
}