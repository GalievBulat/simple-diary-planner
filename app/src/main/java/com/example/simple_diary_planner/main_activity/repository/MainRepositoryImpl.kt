package com.example.simple_diary_planner.main_activity.repository

import com.example.core_data.model.TaskEntity
import javax.inject.Inject


class MainRepositoryImpl @Inject constructor(
    private val jsonDataSource: com.example.core_data.json.JsonDataSource,
    private val taskDao: com.example.core_data.room.TaskDao
) : MainRepository {
    override suspend fun loadTasks(): List<TaskEntity> {
        return jsonDataSource.loadTasks()
    }

    override suspend fun insertTasks(tasks: List<TaskEntity>) {
        taskDao.insertTasks(tasks)
    }
}
