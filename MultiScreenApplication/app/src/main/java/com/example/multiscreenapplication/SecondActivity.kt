package com.example.multiscreenapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val firstName = intent.getStringExtra("extra_first_name")
        val lastName = intent.getStringExtra("extra_last_name")

        val textView: TextView = findViewById(R.id.text)
        textView.text = "Your name is $firstName $lastName"
    }
}