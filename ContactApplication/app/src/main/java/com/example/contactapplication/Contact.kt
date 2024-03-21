package com.example.contactapplication

import android.net.Uri

data class Contact(
    val image: Uri,
    val name: String,
    val phoneNumber: String
)
