package com.example.retrofitexample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitexample.data.SampleJSONDataModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PostsViewModel(private val repo: Repo): ViewModel() {

    val postsLiveData = MutableLiveData<SampleJSONDataModel>()

    private fun getAllPosts() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repo.getAllPosts()
            if(response.isSuccessful) {
                postsLiveData.postValue(response.body())
            }
        }
    }

    init {
        getAllPosts()
    }
}