package com.example.feature_create_task.domain

import com.example.core_data.model.TaskEntity
import com.example.core_navigation.utils.TaskResult
import kotlinx.coroutines.flow.Flow

interface CreateTaskUseCase {
    suspend fun createTask(task: TaskEntity): Flow<TaskResult<Unit?>>
    suspend fun isTaskTimeAvailable(task: TaskEntity): Boolean
}
