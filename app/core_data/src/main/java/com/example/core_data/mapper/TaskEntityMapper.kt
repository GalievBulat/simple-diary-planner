package com.example.core_data.mapper

import com.example.core_data.model.TaskEntity

class TaskEntityToTaskMapper {
    fun map(taskEntity: TaskEntity): com.example.core_model.Task {
        return com.example.core_model.Task(
            id = taskEntity.id,
            name = taskEntity.name,
            dateStart = taskEntity.dateStart,
            dateFinish = taskEntity.dateFinish,
            description = taskEntity.description
        )
    }
    fun map(task: com.example.core_model.Task): TaskEntity {
        return TaskEntity(
            id = task.id,
            name = task.name,
            dateStart = task.dateStart,
            dateFinish = task.dateFinish,
            description = task.description
        )

    }
}
