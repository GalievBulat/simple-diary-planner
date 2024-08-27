package com.example.feature_calendar.presentation

sealed class CalendarEvent {
    data class SelectDate(val date: Long) : CalendarEvent()
}