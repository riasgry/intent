package com.example.myintentapp

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val nama = findViewById<EditText>(R.id.nama)
        val email = findViewById<EditText>(R.id.email)
        val phone = findViewById<EditText>(R.id.phone)
        val button= findViewById<Button>(R.id.button)

        button.setOnClickListener {
            var name = nama.text.toString()
            var emailu = email.text.toString()
            var phoneu = phone.text.toString()


            val intent = Intent (this@MainActivity,SecondActivity::class.java)
            intent.putExtra("Name",name)
            intent.putExtra("Email",emailu)
            intent.putExtra("Phone",phoneu)
            startActivity(intent)

        }

    }


}
