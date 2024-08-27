package com.example.core_navigation.utils

sealed interface TaskResult<T> {

        data class Error<T>(val message: String?): TaskResult<T?>

        data class Success<T>(val data: T?): TaskResult<T?>
}