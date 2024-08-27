package com.example.simple_diary_planner.feature_task_detail.repository

import com.example.core_data.model.TaskEntity


interface TaskDetailRepository {
    suspend fun getTaskById(taskId: Int): TaskEntity
}