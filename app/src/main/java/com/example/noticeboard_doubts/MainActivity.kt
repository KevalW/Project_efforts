package com.example.noticeboard_doubts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var btnSignUp: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSignUp = findViewById(R.id.signUp)

        btnSignUp.setOnClickListener{
            val intent = Intent(this,signupPage::class.java)
            startActivity(intent)
        }
    }
}