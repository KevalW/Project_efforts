package com.example.noticeboard_doubts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {


    private lateinit var signupTxt: TextView
    private lateinit var forgotTxt: TextView
    private lateinit var emailBox: EditText
    private lateinit var passwordBox: EditText
    private lateinit var btnSignIn: Button

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        signupTxt = findViewById(R.id.signUp)
        forgotTxt = findViewById(R.id.frgtpassword)
        emailBox = findViewById(R.id.edtMail)
        passwordBox = findViewById(R.id.edtpass)
        btnSignIn = findViewById(R.id.signIn)

        mAuth = FirebaseAuth.getInstance()

        signupTxt.setOnClickListener{
            val intent = Intent(this,SignupPage::class.java)
            startActivity(intent)
        }

        forgotTxt.setOnClickListener{
            Toast.makeText(this@MainActivity,"will update soon", Toast.LENGTH_SHORT).show()
        }

        btnSignIn.setOnClickListener{
            val email = emailBox.text.toString()
            val password = passwordBox.text.toString()

            login(email,password);
        }
    }

    private fun login(email: String, password: String) {
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    val intent = Intent(this@MainActivity, ChatSection::class.java)
                    startActivity(intent)

                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(this, "User doesn't exist", Toast.LENGTH_SHORT).show()
                }
            }
    }
}