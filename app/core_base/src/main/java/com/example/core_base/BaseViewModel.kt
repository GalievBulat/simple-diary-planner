package com.example.core_base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {

    val _error: MutableLiveData<String?> = MutableLiveData()
    val error: LiveData<String?> = _error

    fun removeError() {
        _error.postValue(null)
    }
}
