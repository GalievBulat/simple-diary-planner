package com.example.simple_diary_planner.feature_task_detail.presentation

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class TaskPreviewParameterProvider: PreviewParameterProvider<com.example.core_model.Task> {
    override val values = sequenceOf(
        com.example.core_model.Task(
            0,
            "Task name",
            1720177200000,
            1720180800000,
            "Task description"
        ),
    )
}