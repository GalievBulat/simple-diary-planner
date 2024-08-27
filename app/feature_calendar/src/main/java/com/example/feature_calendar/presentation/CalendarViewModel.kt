package com.example.feature_calendar.presentation

import androidx.lifecycle.viewModelScope
import com.example.feature_calendar.domain.CalendarUseCase
import com.example.core_navigation.utils.TaskResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CalendarViewModel @Inject constructor(private val calendarUseCase: CalendarUseCase) : com.example.core_base.BaseViewModel() {
    private val _state = MutableStateFlow(CalendarState())
    val state: StateFlow<CalendarState> get() = _state.asStateFlow()

    init {
        loadTasksForSelectedDate()
    }

    fun onSelectDate(event: CalendarEvent) {
        when (event) {
            is CalendarEvent.SelectDate -> {
                _state.value = _state.value.copy(selectedDate = event.date)
                loadTasksForSelectedDate()
            }
        }
    }

    private fun loadTasksForSelectedDate() {
        viewModelScope.launch {
            calendarUseCase.getTasksForDate(_state.value.selectedDate).collect { result ->
                when (result) {
                    is com.example.core_navigation.utils.TaskResult.Success -> _state.value = _state.value.copy(tasks = result.data ?: emptyList())
                    is com.example.core_navigation.utils.TaskResult.Error -> _error.value = result.message
                }
            }
        }
    }
}
