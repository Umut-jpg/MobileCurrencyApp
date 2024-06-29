package com.example.mycurrencyapp.Service

import com.example.mycurrencyapp.Model.ApiResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("today.json")

    fun getData(): Call<ApiResponse>


}