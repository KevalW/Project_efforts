package com.example.noticeboard_doubts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    private lateinit var signupTxt: TextView
    private lateinit var forgotTxt: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        signupTxt = findViewById(R.id.signUp)
        forgotTxt = findViewById(R.id.frgtpassword)

        signupTxt.setOnClickListener{
            val intent = Intent(this,signupPage::class.java)
            startActivity(intent)
        }
        forgotTxt.setOnClickListener{
            Toast.makeText(this@MainActivity,"will update soon", Toast.LENGTH_SHORT).show()
        }
    }
}