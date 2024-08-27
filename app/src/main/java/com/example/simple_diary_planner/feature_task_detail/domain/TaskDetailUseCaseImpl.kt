package com.example.simple_diary_planner.feature_task_detail.domain

import com.example.simple_diary_planner.feature_task_detail.repository.TaskDetailRepository
import com.example.simple_diary_planner.utils.TaskResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


class TaskDetailUseCaseImpl @Inject constructor(
    private val repository: TaskDetailRepository,
    private val mapper: com.example.core_data.mapper.TaskEntityToTaskMapper
) : TaskDetailUseCase {
    override suspend fun getTaskById(taskId: Int): Flow<TaskResult<com.example.core_model.Task?>> = flow {
        try {
            val taskEntity = repository.getTaskById(taskId)
            val task = mapper.map(taskEntity)
            emit(TaskResult.Success(task))
        } catch (e: Exception) {
            emit(TaskResult.Error(e.message))
        }
    }.flowOn(Dispatchers.IO)
}
