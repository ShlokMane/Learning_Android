package com.example.weatheapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.weatheapp.di.ApplicationClass
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var weatherViewModelFactory: WeatherViewModelFactory
    private lateinit var weatherViewModel: WeatherViewModel
    private lateinit var progressBar: ProgressBar
    private lateinit var cityNameET: EditText
    private lateinit var getWeatherButton: Button
    private lateinit var cityDetailsTV: TextView
    private lateinit var weatherImage: ImageView
    private lateinit var weatherDetailsTV: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as ApplicationClass).applicationComponent.inject(this)

        init()

        getWeatherButton.setOnClickListener {
            weatherViewModel.getWeatherDetails(cityNameET.text.toString())
        }

        weatherViewModel.weatherDetailLiveData.observe(this) {
            val currentWeatherType = it.current.condition.text
            val currentWeatherTempratureInC = it.current.temp_c
            Glide.with(this)
                .load("https:${it.current.condition.icon}")
                .into(weatherImage)
            weatherDetailsTV.text = "$currentWeatherType ,  $currentWeatherTempratureInC"
            cityDetailsTV.text = "${it.location.name}, ${it.location.region}"

        }
        weatherViewModel.progressBarLiveData.observe(this) {
            if (it) {
                progressBar.visibility = View.VISIBLE
            } else {
                progressBar.visibility = View.GONE
            }
        }
    }

    private fun init() {
        weatherViewModel =
            ViewModelProvider(this, weatherViewModelFactory).get(WeatherViewModel::class.java)

        progressBar = findViewById(R.id.progress_bar)
        cityNameET = findViewById(R.id.cityNameET)
        getWeatherButton = findViewById(R.id.getWeatherButton)
        weatherImage = findViewById(R.id.weatherIV)
        weatherDetailsTV = findViewById(R.id.weatherDetailsTV)
        cityDetailsTV = findViewById(R.id.cityDetailsTV)
    }
}