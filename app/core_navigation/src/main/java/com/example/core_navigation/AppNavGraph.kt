package com.example.core_navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

sealed class Screen(val route: String) {
    data object Calendar : Screen("calendar")
    data object TaskDetail : Screen("task_detail/{taskId}") {
        fun createRoute(taskId: Int) = "task_detail/$taskId"
    }
    data object CreateTask: Screen("create_task")
}
@Composable
fun DiaryNavGraph(
    navController: NavHostController,
    calendarScreen: @Composable (NavHostController) -> Unit,
    taskDetailScreen: @Composable (NavHostController) -> Unit,
    createTaskScreen: @Composable (NavHostController) -> Unit
) {
    NavHost(navController = navController, startDestination = Screen.Calendar.route) {
        composable(Screen.Calendar.route) {
            calendarScreen(navController)
        }
        composable(Screen.TaskDetail.route) {
            taskDetailScreen(navController)
        }
        composable(Screen.CreateTask.route) {
            createTaskScreen(navController)
        }
    }
}

