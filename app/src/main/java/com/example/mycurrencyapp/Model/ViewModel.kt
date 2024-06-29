package com.example.mycurrencyapp.Model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.util.Currency


class CurrencyViewModel : ViewModel() {
    private val _apiResponse = MutableLiveData<ApiResponse?>()
    val apiResponse: LiveData<ApiResponse?> get() = _apiResponse
    val Api= Api()
    init {
        fetchData()
    }

    private fun fetchData() {
        Api.fetchData { response ->
            _apiResponse.postValue(response)
        }
    }
}


