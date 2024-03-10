package com.example.listandrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListAdapter
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView: ListView = findViewById(R.id.listView)
        val listOfNames = mutableListOf<String>("Shlok", "Varsha", "Mane", "Roy")
        val edt: EditText = findViewById(R.id.nameEditText)
        val btn: Button = findViewById(R.id.addNameButton)
        val nameAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listOfNames)


        btn.setOnClickListener {
            if(edt.text.isEmpty() || btn.text.isBlank()) {
                Toast.makeText(this, "Enter A name", Toast.LENGTH_SHORT).show()
            } else {
                listOfNames.add(edt.text.toString())
                nameAdapter.notifyDataSetChanged()
            }
        }

       listView.adapter = nameAdapter

        listView.onItemClickListener =
            OnItemClickListener { p0, p1, p2, p3 ->
                listOfNames.removeAt(p2)
                nameAdapter.notifyDataSetChanged()
            }


    }
}