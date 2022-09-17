package com.example.noticeboard_doubts

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.noticeboard_doubts.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class SignupPage : AppCompatActivity() {

    private lateinit var firstName: EditText
    private lateinit var lastName: EditText
    private lateinit var emailBox: EditText
    private lateinit var passwordBox: EditText
    private lateinit var btnSignUp: Button

    private lateinit var mAuth: FirebaseAuth

    private lateinit var dRefrence: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sigup_page)

        firstName = findViewById(R.id.fName)
        lastName = findViewById(R.id.lName)
        emailBox = findViewById(R.id.sEmail)
        passwordBox = findViewById(R.id.sPassword)
        btnSignUp = findViewById(R.id.signupin)

        mAuth = FirebaseAuth.getInstance()

        dRefrence = FirebaseDatabase.getInstance().getReference()


        btnSignUp.setOnClickListener{

            val firstName = firstName.text.toString()
            val lastName = lastName.text.toString()
            val email = emailBox.text.toString()
            val password = passwordBox.text.toString()

            newUserInfo()
            signUp(email,password)
        }
    }

    private fun newUserInfo() {
        val email = emailBox.text.toString()
        val password = passwordBox.text.toString()

        val userId = dRefrence.push().key!!

        val user = User(userId,email,password)
        dRefrence.child(userId).setValue(user)
            .addOnCompleteListener{
                Toast.makeText(this, "succesfully incerted", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener{err ->
                Toast.makeText(this, "fail to upload ${err.message}", Toast.LENGTH_SHORT).show()
            }

    }


    private fun signUp(email: String, password: String) {
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val intent = Intent(this@SignupPage, MainActivity::class.java)
                    startActivity(intent)
                }else {
                    Toast.makeText(this, "something went wrong", Toast.LENGTH_SHORT).show()
                }
            }
    }
}