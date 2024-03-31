package com.example.retrofitexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitexample.data.RetrofitBuilder

class MainActivity : AppCompatActivity() {

    private lateinit var postsViewModel: PostsViewModel
    private lateinit var postViewModelFactory: PostViewModelFactory
    private lateinit var repo: Repo
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()

        postsViewModel.postsLiveData.observe(this) {
            Log.i("Post Live Data", it.toString() )
        }
    }

    private fun init() {
        repo = Repo(RetrofitBuilder.getRetrofitServicesInstance())
        postViewModelFactory = PostViewModelFactory(repo)
        postsViewModel = ViewModelProvider(this, postViewModelFactory).get(PostsViewModel::class.java)
    }
}