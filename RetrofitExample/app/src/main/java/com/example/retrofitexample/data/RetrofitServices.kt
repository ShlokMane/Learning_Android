package com.example.retrofitexample.data

import retrofit2.Response
import retrofit2.http.GET

interface RetrofitServices {

    @GET("/posts")
    suspend fun getAllPost() :Response<SampleJSONDataModel>
}