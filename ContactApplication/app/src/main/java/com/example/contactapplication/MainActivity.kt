package com.example.contactapplication

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var contactRV: RecyclerView
    private lateinit var addContactFAB: FloatingActionButton
    private lateinit var previewImageIV: ImageView
    private lateinit var contactAdapter: ContactAdapter
    private lateinit var addContactButton: Button
    private lateinit var contactNameET: EditText
    private lateinit var contactPhoneNumberET: EditText
    private lateinit var dialog: Dialog
    //val listOfContacts = mutableListOf<Contact>()

    private lateinit var repo: Repo
    private lateinit var viewModelFactory: ContactViewModelFactory
    private lateinit var viewModel: ContactViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        repo = Repo()
        viewModelFactory = ContactViewModelFactory(repo)
        viewModel = ViewModelProvider(this, viewModelFactory).get(ContactViewModel::class.java)

        contactRV = findViewById(R.id.contactListRV)
        addContactFAB = findViewById(R.id.addContactFAB)
        contactRV.layoutManager = LinearLayoutManager(this)

        viewModel.listOfContactLiveData.observe(this) {

            contactAdapter = ContactAdapter(it)
            contactRV.adapter = contactAdapter
        }
        addContactFAB.setOnClickListener {
            showDialog()
        }
    }

    private fun showDialog() {
        dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.add_contact_alert_dialog)

        contactNameET = dialog.findViewById(R.id.nameET)
        contactPhoneNumberET = dialog.findViewById(R.id.phoneNumberET)
        previewImageIV = dialog.findViewById(R.id.imagePreviewIV)
        val chooseImageButton: Button = dialog.findViewById(R.id.chooseImageButton)
        addContactButton = dialog.findViewById(R.id.addContactButton)

        chooseImageButton.setOnClickListener {
            val galleryIntent =
                Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(galleryIntent, 101)
        }



        dialog.show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 101 && resultCode == RESULT_OK) {
            previewImageIV.setImageURI(data?.data)
            previewImageIV.visibility = View.VISIBLE

            addContactButton.setOnClickListener {
                if (contactNameET.text.isBlank() || contactNameET.text.isEmpty()) {
                    Toast.makeText(this, "Please enter contact's name", Toast.LENGTH_SHORT).show()
                } else if (contactPhoneNumberET.text.isEmpty() || contactNameET.text.isBlank()) {
                    Toast.makeText(this, "Please enter contact's phone number", Toast.LENGTH_SHORT)
                        .show()
                } else if (previewImageIV.visibility == View.GONE) {
                    Toast.makeText(this, "Please add contact's image", Toast.LENGTH_SHORT).show()
                } else {
//                    listOfContacts.add(
//                        Contact(
//                            data?.data!!,
//                            contactNameET.text.toString(),
//                            contactPhoneNumberET.text.toString()
//                        )
//                    )
                    viewModel.addContact(
                        Contact(data?.data!!,
                            contactNameET.text.toString(),
                            contactPhoneNumberET.text.toString()))

                    dialog.dismiss()
                }
            }
        }
    }
}
