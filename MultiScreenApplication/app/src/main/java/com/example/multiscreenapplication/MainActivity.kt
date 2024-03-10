package com.example.multiscreenapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn: Button = findViewById(R.id.btn)
        val firstNameET: EditText = findViewById(R.id.first_name)
        val lastNameET: EditText = findViewById(R.id.last_name)

        btn.setOnClickListener {
            if(firstNameET.text.isBlank() || firstNameET.text.isEmpty() || lastNameET.text.isBlank() || lastNameET.text.isEmpty()) {
                Toast.makeText(this, "Please enter first and last name", Toast.LENGTH_LONG).show()
            } else {
                val firstName: String = firstNameET.text.toString()
                val lastName: String = lastNameET.text.toString()

                val intent: Intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("extra_first_name", firstName)
                intent.putExtra("extra_last_name", lastName)
                startActivity(intent)
            }
        }
    }
}