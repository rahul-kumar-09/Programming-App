package com.coprogramming.cprogramming.LoginPage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.coprogramming.cprogramming.MainActivity
import com.coprogramming.cprogramming.R
import com.coprogramming.cprogramming.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.MainScope

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth

        binding.login.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            val pass = binding.etPass.text.toString().trim()

            if (email.isNotEmpty() && pass.isNotEmpty()){
                auth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(this) {task->
                    if (task.isSuccessful){
                        updateUI()
                    }else {
                        Toast.makeText(this, "Please Signup then Login.", Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this, "Empty field not allowed", Toast.LENGTH_SHORT).show()
            }

        }

        binding.signUp.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
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