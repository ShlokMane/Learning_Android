package com.example.retrofitexample

import com.example.retrofitexample.data.RetrofitServices

class Repo(private val retrofitServices: RetrofitServices) {
    suspend fun getAllPosts() = retrofitServices.getAllPost()
}