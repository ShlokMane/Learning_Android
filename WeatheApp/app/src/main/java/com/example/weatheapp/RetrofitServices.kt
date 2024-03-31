package com.example.weatheapp

import com.example.weatheapp.data.WeatherDataModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitServices {

    @GET("/v1/current.json?key=ec5c8aff29944be0bad165415243103")
    suspend fun getWeatherDetail(@Query("q") city: String): Response<WeatherDataModel>
}