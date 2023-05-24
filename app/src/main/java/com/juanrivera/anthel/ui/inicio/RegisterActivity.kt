package com.juanrivera.anthel.ui.inicio

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.juanrivera.anthel.R
import com.juanrivera.anthel.databinding.ActivityRegisterBinding
import com.juanrivera.anthel.nav_view

class RegisterActivity:AppCompatActivity() {

    private lateinit var registerBinding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerBinding = ActivityRegisterBinding.inflate(layoutInflater)
        val view = registerBinding.root
        setContentView(view)

        registerBinding.returnButton.setOnClickListener {
            val intent = Intent(this@RegisterActivity , LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
        registerBinding.registerButton.setOnClickListener {
            val intent = Intent(this@RegisterActivity , nav_view::class.java)
            startActivity(intent)
            finish()
        }
    }
}