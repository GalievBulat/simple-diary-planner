package com.example.simple_diary_planner.feature_task_detail.domain

import com.example.simple_diary_planner.utils.TaskResult
import kotlinx.coroutines.flow.Flow

interface TaskDetailUseCase {
    suspend fun getTaskById(taskId: Int): Flow<TaskResult<com.example.core_model.Task?>>
}