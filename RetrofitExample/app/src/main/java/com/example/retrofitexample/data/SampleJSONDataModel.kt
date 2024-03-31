package com.example.retrofitexample.data

import com.example.retrofitexample.data.Post

data class SampleJSONDataModel(
    val limit: Int,
    val posts: List<Post>,
    val skip: Int,
    val total: Int
)