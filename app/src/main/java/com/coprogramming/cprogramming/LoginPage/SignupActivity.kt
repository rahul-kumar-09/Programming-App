package com.coprogramming.cprogramming.LoginPage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.coprogramming.cprogramming.MainActivity
import com.coprogramming.cprogramming.R
import com.coprogramming.cprogramming.databinding.ActivitySignupBinding
import com.coprogramming.cprogramming.model.UserModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.MainScope

class SignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth
        database = Firebase.database.reference

        binding.btnRegister.setOnClickListener {
            val email = binding.dEmail.text.toString().trim()
            val pass = binding.tvPassword.text.toString().trim()

            if (email.isNotEmpty() && pass.isNotEmpty()){
                auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(this) {task->
                    if (task.isSuccessful){
                        saveData()
                        updateUI()
                    } else {
                        Toast.makeText(this, "Account already created.", Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this, "Empty field not allowed", Toast.LENGTH_SHORT).show()
            }

        }

        binding.btnLoginButton.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }


    }

    private fun saveData() {
        val sEmail = binding.dEmail.text.toString().trim()
        val sName = binding.dName.text.toString().trim()
        val sAddress = binding.dAddress.text.toString().trim()
        val sPass = binding.tvPassword.text.toString().trim()

        val userID = FirebaseAuth.getInstance().currentUser!!.uid

        val user = UserModel(sName,sEmail,sAddress)

        database.child("User").child(userID).setValue(user)

    }

    private fun updateUI() {
        startActivity(Intent(this, MainActivity::class.java))
        finishAffinity()
    }

    override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        if (currentUser != null){
            updateUI()
            finishAffinity()
        }

    }

}