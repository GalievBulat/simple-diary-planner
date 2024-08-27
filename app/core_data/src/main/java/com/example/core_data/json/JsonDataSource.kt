package com.example.core_data.json

import android.content.Context
import com.example.core_data.model.TaskEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class JsonDataSource(private val context: Context) {

    suspend fun loadTasks(): List<TaskEntity> = withContext(Dispatchers.IO) {
        val jsonString = context.assets.open("tasks.json").use { it.readBytes().toString(Charsets.UTF_8) }
        val taskType = object : TypeToken<List<TaskEntity>>() {}.type
        Gson().fromJson(jsonString, taskType)
    }
}
