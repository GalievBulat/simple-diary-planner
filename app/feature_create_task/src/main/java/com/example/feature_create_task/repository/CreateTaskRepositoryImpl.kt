package com.example.feature_create_task.repository

import com.example.core_data.model.TaskEntity
import javax.inject.Inject

class CreateTaskRepositoryImpl @Inject constructor(
    private val taskDao: com.example.core_data.room.TaskDao
) : CreateTaskRepository {
    override suspend fun saveTask(taskEntity: TaskEntity) {
        taskDao.insertTask(taskEntity)
    }
    override suspend fun isTimeAvailable(task: TaskEntity): Boolean {
        val tasks = taskDao.getTasksInTimeRange(task.dateStart, task.dateFinish)
        return tasks.isEmpty()
    }
}
