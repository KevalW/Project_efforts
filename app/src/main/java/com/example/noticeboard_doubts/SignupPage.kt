package com.example.noticeboard_doubts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class SignupPage : AppCompatActivity() {

    private lateinit var emailBox: EditText
    private lateinit var passwordBox: EditText
//    private lateinit var confPasswordBox: EditText
    private lateinit var btnSignUp: Button

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sigup_page)

        emailBox = findViewById(R.id.sEmail)
        passwordBox = findViewById(R.id.sPassword)
//        confPasswordBox = findViewById(R.id.sConfirmPassword)
        btnSignUp = findViewById(R.id.signupin)

        mAuth = FirebaseAuth.getInstance()

        btnSignUp.setOnClickListener{
            val email = emailBox.text.toString()
            val password = emailBox.text.toString()
//            val cPassword = emailBox.text.toString()

            signUp(email,password)


        }
    }
    private fun signUp(email: String, password: String) {
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    val intent = Intent(this@SignupPage, MainActivity::class.java)
                    startActivity(intent)

                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(this, "something went wrong", Toast.LENGTH_SHORT).show()
                }
            }
    }
}