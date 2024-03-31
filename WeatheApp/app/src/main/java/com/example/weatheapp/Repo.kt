package com.example.weatheapp

import javax.inject.Inject

class Repo @Inject constructor(private val retrofitServices: RetrofitServices) {

    suspend fun getWeatherDetails(city: String) = retrofitServices.getWeatherDetail(city)
}