package com.example.core_data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.core_data.model.TaskEntity

@Database(entities = [TaskEntity::class], version = 1)
abstract class TaskDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}
