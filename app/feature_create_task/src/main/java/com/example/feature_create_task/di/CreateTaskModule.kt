package com.example.feature_create_task.di

import com.example.core_data.room.TaskDao
import com.example.feature_create_task.domain.CreateTaskUseCase
import com.example.feature_create_task.domain.CreateTaskUseCaseImpl
import com.example.feature_create_task.repository.CreateTaskRepository
import com.example.feature_create_task.repository.CreateTaskRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object CreateTaskModule {

    @Provides
    fun provideCreateTaskRepository(taskDao: TaskDao): CreateTaskRepository {
        return CreateTaskRepositoryImpl(taskDao)
    }

    @Provides
    fun provideCreateTaskUseCase(repository: CreateTaskRepository): CreateTaskUseCase {
        return CreateTaskUseCaseImpl(repository)
    }
}
