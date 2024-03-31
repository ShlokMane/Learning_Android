package com.example.weatheapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatheapp.data.WeatherDataModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class WeatherViewModel @Inject constructor(private val repo: Repo) : ViewModel() {

    val weatherDetailLiveData = MutableLiveData<WeatherDataModel>()
    val progressBarLiveData = MutableLiveData<Boolean>(false)

    fun getWeatherDetails(city: String) {
        viewModelScope.launch(Dispatchers.IO) {
            progressBarLiveData.postValue(true)
            val response = repo.getWeatherDetails(city)
            if (response.isSuccessful) {
                weatherDetailLiveData.postValue(response.body())
            }
            progressBarLiveData.postValue(false)
        }
    }
}