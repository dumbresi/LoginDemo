package com.example.loginregister.ui.theme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.loginregister.R
import com.example.loginregister.ui.theme.fragments.LoginFragment

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val login_btn = findViewById<Button>(R.id.login_btn)
        val register_btn=findViewById<Button>(R.id.register_btn)
        val frame= findViewById<FrameLayout>(R.id.login_frame)
        setupView()

    }

    fun setupView(){
        supportFragmentManager.beginTransaction().replace(R.id.login_frame, LoginFragment()).commit()
    }
}