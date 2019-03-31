package com.example.myintentapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException

class SecondActivity : Activity() {
    val SELECT_PICTURE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        profile.setOnClickListener {
            dispatchGalleryIntent()
        }

        var intent = intent
        val name = intent.getStringExtra("Name")
        val emailu = intent.getStringExtra("Email")
        val phoneu = intent.getStringExtra("Phone")

        val result = findViewById<TextView>(R.id.result)
        result.text = "Name: "+name+"\nEmail: "+emailu+"\nPhone: "+phoneu

    }

    fun dispatchGalleryIntent() {
        val intent = Intent()
        intent.type ="image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent,"Select image"), SELECT_PICTURE)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == SELECT_PICTURE && resultCode == Activity.RESULT_OK)
        {
            try {
                val uri = data!!.data
                profile.setImageURI(uri)
            }catch (e: IOException){
                e.printStackTrace()
            }
        }

    }
}
