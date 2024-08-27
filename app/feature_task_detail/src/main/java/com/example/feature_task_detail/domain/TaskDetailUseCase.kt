package com.example.feature_task_detail.domain

import com.example.core_model.Task
import com.example.core_navigation.utils.TaskResult
import kotlinx.coroutines.flow.Flow

interface TaskDetailUseCase {
    suspend fun getTaskById(taskId: Int): Flow<TaskResult<Task?>>
}