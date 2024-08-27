package com.example.feature_calendar.domain
import com.example.core_model.Task
import com.example.feature_calendar.repository.CalendarRepository
import com.example.core_navigation.utils.TaskResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.time.Instant
import java.time.ZoneId
import javax.inject.Inject


class CalendarUseCaseImpl @Inject constructor(
    private val taskRepository: CalendarRepository,
    private val mapper: com.example.core_data.mapper.TaskEntityToTaskMapper
) : CalendarUseCase {
    override suspend fun getTasksForDate(date: Long): Flow<com.example.core_navigation.utils.TaskResult<List<Task>?>> = flow {
        try {
            val datetime = Instant.ofEpochMilli(date).atZone(ZoneId.systemDefault()).toLocalDateTime().toLocalDate()
            val startDate = datetime.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()
            val endDate = datetime.plusDays(1).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()

            val taskEntities = taskRepository.getTasksForDate(startDate, endDate)
            val tasks = taskEntities.map { mapper.map(it) }.sortedBy { it.dateStart }
            emit(com.example.core_navigation.utils.TaskResult.Success(tasks))
        } catch (e: Exception) {
            emit(com.example.core_navigation.utils.TaskResult.Error(e.message))
        }
    }.flowOn(Dispatchers.IO)
}
