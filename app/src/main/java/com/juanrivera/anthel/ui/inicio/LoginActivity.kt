package com.juanrivera.anthel.ui.inicio

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
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
        lateinit var auth: FirebaseAuth
        auth = Firebase.auth

        loginBinding.inicioButton.setOnClickListener {
            if(loginBinding.emailEditext.text.toString().isEmpty()){
                Toast.makeText(applicationContext, "Debes ingresar un correo", Toast.LENGTH_LONG).show()
            }else if(loginBinding.passwordEditext.text.toString().isEmpty()){
                Toast.makeText(applicationContext, "Debes ingresar la contraseña", Toast.LENGTH_LONG).show()
            }else{
                auth.signInWithEmailAndPassword(loginBinding.emailEditext.text.toString(), loginBinding.passwordEditext.text.toString())
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            val intent = Intent(this@LoginActivity , nav_view::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(
                                baseContext,
                                "Authentication failed.",
                                Toast.LENGTH_SHORT,
                            ).show()
                        }
                    }
            }
        }
        loginBinding.registerButton.setOnClickListener {
            val intent = Intent(this@LoginActivity , RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}