package com.coprogramming.cprogramming.LoginPage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.coprogramming.cprogramming.MainActivity
import com.coprogramming.cprogramming.R
import com.coprogramming.cprogramming.databinding.ActivitySignupBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.MainScope

class SignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth

        binding.btnRegister.setOnClickListener {
            val email = binding.dEmail.text.toString().trim()
            val pass = binding.tvPassword.text.toString().trim()

            if (email.isNotEmpty() && pass.isNotEmpty()){
                auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(this) {task->
                    if (task.isSuccessful){
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