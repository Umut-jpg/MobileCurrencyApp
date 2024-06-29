package com.example.mycurrencyapp.Model

import android.util.Log
import com.example.mycurrencyapp.Service.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



class Api {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://finans.truncgil.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    private val service = retrofit.create(ApiService::class.java)
/*
    fun fetchData(callback: (ApiResponse?) -> Unit) {
        val call = service.getData()
        call.enqueue(object : Callback<ApiResponse> {
            override fun onResponse(
                call: Call<ApiResponse>,
                response: Response<ApiResponse>
            ) {
                if (response.isSuccessful) {
                    Log.d("API_RESPONSE", "Başarılı yanıt alındı")
                    val apiResponse = response.body()
                    callback(apiResponse)
                } else {
                    Log.e("API_ERROR", "Başarısız yanıt alındı")
                    callback(null)
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                Log.e("API_FAILURE", "İstek başarısız oldu", t)
                callback(null)
            }
        })




    }

*/

    fun fetchData(callback: (ApiResponse?) -> Unit) {
        val call = service.getData()
        call.enqueue(object : Callback<ApiResponse> {
            override fun onResponse(
                call: Call<ApiResponse>,
                response: Response<ApiResponse>
            ) {
                if (response.isSuccessful) {
                    Log.d("API_RESPONSE", "Başarılı yanıt alındı")
                    val apiResponse = response.body()
                    callback(apiResponse)
                } else {
                    Log.e("API_ERROR", "Başarısız yanıt alındı")
                    callback(null)
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                Log.e("API_FAILURE", "İstek başarısız oldu", t)
                callback(null)
            }
        })
    }

}



