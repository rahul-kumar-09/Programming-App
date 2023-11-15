package com.coprogramming.cprogramming

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.coprogramming.cprogramming.LoginPage.LoginActivity
import com.coprogramming.cprogramming.fragments.AboutAppFragment
import com.coprogramming.cprogramming.fragments.DashboardFragment
import com.coprogramming.cprogramming.fragments.InterViewQuesFragment
import com.coprogramming.cprogramming.myProfile.ProfileActivity
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var coordinatorLayout: CoordinatorLayout
    private lateinit var toolbar: Toolbar
    private lateinit var frameLayout: FrameLayout
    private lateinit var navigationView: NavigationView

    private var previousMenuItem:MenuItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawerLayout)
        coordinatorLayout = findViewById(R.id.coordinatorLayout)
        toolbar = findViewById(R.id.toolbar)
        frameLayout = findViewById(R.id.frameLayout)
        navigationView = findViewById(R.id.navigationView)

        setUpToolbar()
        openDashboard()

        val actionBarDrawerToggle = ActionBarDrawerToggle(this, drawerLayout, R.string.Open_Drawer, R.string.Close_Drawer)
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        navigationView.setNavigationItemSelectedListener {
            if (previousMenuItem !=  null){
                previousMenuItem?.isChecked = false
            }
            it.isCheckable = true
            it.isChecked = true
            previousMenuItem = it

            when(it.itemId){
                R.id.dashboard -> {
                    openDashboard()
                }

                R.id.about_app -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout, AboutAppFragment())
                        .commit()
                    supportActionBar?.title = "About App"
                    drawerLayout.closeDrawers()
                }
                R.id.interView -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout, InterViewQuesFragment())
                        .commit()
                    supportActionBar?.title = "Interview Question"
                    drawerLayout.closeDrawers()
                }
                R.id.profile->{
                    startActivity(Intent(this, ProfileActivity::class.java))
                }
                R.id.logout_exit-> {
                    logoutMethod()
                }

            }

            return@setNavigationItemSelectedListener true
        }


    }

    private fun logoutMethod() {

        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("Logout")
        dialog.setMessage("Are you sure to logout.")
        dialog.setIcon(R.drawable.baseline_logout_24)

        dialog.setPositiveButton("Yes"){dialog,which ->
            Firebase.auth.signOut()
            startActivity(Intent(this, LoginActivity::class.java))
            dialog.dismiss()
        }

        dialog.setNegativeButton("No"){dialog,which->
            Toast.makeText(this, "Welcome back", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        dialog.show()

    }

    private fun setUpToolbar(){
        setSupportActionBar(toolbar)
        supportActionBar?.title = "C++ Programming"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home){
            drawerLayout.openDrawer(GravityCompat.START)
        }
        return super.onOptionsItemSelected(item)
    }

    private fun openDashboard(){
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout, DashboardFragment())
            .commit()
        supportActionBar?.title = "Home"
        drawerLayout.closeDrawers()
        navigationView.setCheckedItem(R.id.dashboard)
    }

}