package com.example.loginwithintentactivity

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class UserProfile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user_profile)

        // Get TextView
        val usernameTxt = findViewById<TextView>(R.id.username_txt)
        val emailTxt = findViewById<TextView>(R.id.email_txt)
        val phoneNumbertxt = findViewById<TextView>(R.id.phoneNumber_txt)
        val genderTxt = findViewById<TextView>(R.id.gender_txt)

        // Get data dari intent
        val email = intent.getStringExtra("email")
        val phone = intent.getStringExtra("Phone")
        val username = intent.getStringExtra("Username")
        val gender = intent.getStringExtra("gender")

        // Set the data to the TextViews
        usernameTxt.text = username
        emailTxt.text = email
        phoneNumbertxt.text = phone
        genderTxt.text = gender

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}