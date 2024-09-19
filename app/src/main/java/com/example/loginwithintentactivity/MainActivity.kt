package com.example.loginwithintentactivity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.loginwithintentactivity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val TAG = "MAIN_ACTIVITY"
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate dipanggil")
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize Views
        val emailInput = findViewById<EditText>(R.id.input_email)
        val phoneInput = findViewById<EditText>(R.id.input_phoneNumber)
        val usernameInput = findViewById<EditText>(R.id.input_username)
        val genderInput = findViewById<EditText>(R.id.input_gender)
        val signUpButton = findViewById<Button>(R.id.signUpButton)

        //  Set up click listener untuk sign up button
        signUpButton.setOnClickListener{
            val email = emailInput.text.toString()
            val phone = phoneInput.text.toString()
            val username = usernameInput.text.toString()
            val gender = genderInput.text.toString()

            // Start UserProfile activity and pass the data
            val intent = Intent(this, UserProfile::class.java).apply{
                putExtra('Email: ', email)
                putExtra('Phone: ', phone)
                putExtra('Username: ', username)
                putExtra('Gender: ', gender)
            }
            startActivity(intent)
        }
    }
}