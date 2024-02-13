package com.coprogramming.cprogramming.myProfile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.coprogramming.cprogramming.LoginPage.LoginActivity
import com.coprogramming.cprogramming.MainActivity
import com.coprogramming.cprogramming.R
import com.coprogramming.cprogramming.databinding.ActivityProfileBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = Firebase.database.reference

        val userId = FirebaseAuth.getInstance().currentUser!!.uid

        database.child("User").child(userId).get().addOnSuccessListener(this) {
            val name = it.child("name").value.toString()
            val email = it.child("email").value.toString()
            val address = it.child("address").value.toString()

            binding.txtName.text = name
            binding.txtEmail.text = email
            binding.txtAddress.text = address
        }.addOnFailureListener {
            Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
        }





    }
}