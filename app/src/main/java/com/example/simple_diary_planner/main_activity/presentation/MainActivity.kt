package com.example.simple_diary_planner.main_activity.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.feature_calendar.presentation.CalendarScreen
import com.example.feature_create_task.presentation.CreateTaskScreen
import com.example.feature_task_detail.presentation.TaskDetailScreen
import com.example.simple_diary_planner.ui.theme.CalendarAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            CalendarAppTheme{
                val navController = rememberNavController()
                com.example.core_navigation.DiaryNavGraph(navController = navController,
                    calendarScreen = {
                        CalendarScreen()
                            .Create(hiltViewModel(), it)
                    },
                    taskDetailScreen = {
                        TaskDetailScreen()
                            .Create(hiltViewModel(), it)
                    },
                    createTaskScreen = {
                        CreateTaskScreen()
                            .Create(hiltViewModel(), it)
                    })
            }
        }
        viewModel.initializeTasks()
    }
}

