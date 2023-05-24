package com.juanrivera.anthel.ui.inicio

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.juanrivera.anthel.R
import com.juanrivera.anthel.databinding.ActivityLoginBinding
import com.juanrivera.anthel.nav_view

class LoginActivity: AppCompatActivity() {

    private lateinit var loginBinding: ActivityLoginBinding
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginBinding = ActivityLoginBinding.inflate(layoutInflater)
        val view = loginBinding.root
        setContentView(view)
        loginViewModel = ViewModelProvider(this)[LoginViewModel::class.java]

        loginBinding.inicioButton.setOnClickListener {
            if(loginBinding.emailEditext.text.toString().isEmpty()){
                Toast.makeText(applicationContext, "Debes ingresar un correo", Toast.LENGTH_LONG).show()
            }else if(loginBinding.passwordEditext.text.toString().isEmpty()){
                Toast.makeText(applicationContext, "Debes ingresar la contraseña", Toast.LENGTH_LONG).show()
            }else{
                val intent = Intent(this@LoginActivity , nav_view::class.java)
                startActivity(intent)
                finish()
            }
        }
        loginBinding.registerButton.setOnClickListener {
            val intent = Intent(this@LoginActivity , RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}