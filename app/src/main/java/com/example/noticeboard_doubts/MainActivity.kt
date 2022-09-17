package com.example.noticeboard_doubts

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.errorprone.annotations.Var
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
        passwordBox = findViewById(R.id.edtpassword)
        btnSignIn = findViewById(R.id.signIn)

        mAuth = FirebaseAuth.getInstance()

        btnSignIn.setOnClickListener{
            val email = emailBox.text.toString()
            val password = passwordBox.text.toString()

            login(email,password)
        }

        signupTxt.setOnClickListener{
            val intent = Intent(this,SignupPage::class.java)
            startActivity(intent)
        }

        forgotTxt.setOnClickListener{
            Toast.makeText(this@MainActivity,"will update soon", Toast.LENGTH_SHORT).show()
        }


    }

    private fun login(email: String, password: String ) {
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful and task.isComplete) {
                    val intent = Intent(this@MainActivity, ChatSection::class.java)
                    startActivity(intent)
                }else {
                    Toast.makeText(this@MainActivity, "user invalid", Toast.LENGTH_SHORT).show()
                }
            }
    }
}