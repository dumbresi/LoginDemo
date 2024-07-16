package com.example.loginregister.ui.theme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import androidx.lifecycle.ViewModelProvider
import com.example.loginregister.R
import com.example.loginregister.ui.theme.fragments.LoginFragment

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val login_btn = findViewById<Button>(R.id.login_btn)
        val register_btn=findViewById<Button>(R.id.register_btn)
        val frame= findViewById<FrameLayout>(R.id.login_frame)
        val viewModel: LoginViewModel= ViewModelProvider(this).get(LoginViewModel::class.java)

        register_btn.isSelected=true

        login_btn.setOnClickListener{
            login_btn.isSelected=true
            register_btn.isSelected=false
            viewModel.isLogin.postValue(true)
        }

        register_btn.setOnClickListener {
            login_btn.isSelected=false
            register_btn.isSelected=true
            viewModel.isLogin.postValue(false)
        }
        viewModel.isLogin.observe(this,{
            if(viewModel.isLogin.value==true){
                setupView("login")
            }else{
                setupView("register")
            }

        })
    }

    fun setupView(type: String){
        supportFragmentManager.beginTransaction().replace(R.id.login_frame, LoginFragment.newInstance(type)).commit()
    }
}