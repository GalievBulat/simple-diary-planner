package com.example.simple_diary_planner.feature_task_detail.repository

import com.example.core_data.model.TaskEntity
import javax.inject.Inject


class TaskDetailRepositoryImpl @Inject constructor(
    private val taskDao: com.example.core_data.room.TaskDao
) : TaskDetailRepository {
    override suspend fun getTaskById(taskId: Int): TaskEntity {
        return taskDao.getTaskById(taskId)
    }
}
