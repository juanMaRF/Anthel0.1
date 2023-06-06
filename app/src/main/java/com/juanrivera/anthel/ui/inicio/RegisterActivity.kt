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
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import com.juanrivera.anthel.R
import com.juanrivera.anthel.databinding.ActivityRegisterBinding
import com.juanrivera.anthel.nav_view
import com.juanrivera.anthel.ui.entidades.Usuario

class RegisterActivity:AppCompatActivity() {

    private lateinit var registerBinding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerBinding = ActivityRegisterBinding.inflate(layoutInflater)
        val view = registerBinding.root
        setContentView(view)
        val RegisterViewModel = ViewModelProvider(this)[RegisterViewModel::class.java]
        lateinit var auth: FirebaseAuth
        auth = Firebase.auth
        lateinit var Database: FirebaseDatabase
        lateinit var referneceUsuarios: DatabaseReference
        Database = FirebaseDatabase.getInstance()
        var genero:String = ""

        referneceUsuarios = Database.getReference("Usuarios")

        registerBinding.returnButton.setOnClickListener {
            val intent = Intent(this@RegisterActivity , LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
        registerBinding.registerButton.setOnClickListener {
            RegisterViewModel.name_(registerBinding.nameEditText.text.toString())
            RegisterViewModel.email_(registerBinding.emailEditext.text.toString())
            if(registerBinding.femaleRadioButton.isChecked){
                RegisterViewModel.genere_("Mujer")
                genero = "mujer"
            }else{
                RegisterViewModel.genere_("Hombre")
                genero = "Hombre"
            }
            RegisterViewModel.date_(registerBinding.datePicker1.dayOfMonth.toString() + "/" + (registerBinding.datePicker1.month + 1).toString() + "/" + registerBinding.datePicker1.year.toString())
            if (registerBinding.spinner2.selectedItemPosition == 0){
                Toast.makeText(applicationContext,"Debes elegir una ciudad", Toast.LENGTH_LONG).show()
            }else{
                RegisterViewModel.city_(registerBinding.spinner2.getItemAtPosition(registerBinding.spinner2.selectedItemPosition).toString())
            }


            if(!registerBinding.emailEditext.text.toString().isEmpty() && !registerBinding.passwordEditext.text.toString().isEmpty()) {
                auth.createUserWithEmailAndPassword(
                    registerBinding.emailEditext.text.toString(),
                    registerBinding.passwordEditext.text.toString()
                )
                    .addOnCompleteListener(this) { task ->

                        if (RegisterViewModel.contrasprobe(
                                registerBinding.passwordEditext.text.toString(),
                                registerBinding.repPasswordEditText.text.toString()
                            )
                        ) {
                            if (!registerBinding.nameEditText.text.toString().isEmpty()) {
                                if (task.isSuccessful) {

                                    val user: Usuario = Usuario()
                                    user.setParameters(
                                        registerBinding.nameEditText.text.toString(),
                                        registerBinding.emailEditext.text.toString(),
                                        genero,
                                        registerBinding.datePicker1.dayOfMonth.toString() + "/" + (registerBinding.datePicker1.month + 1).toString() + "/" + registerBinding.datePicker1.year.toString(),
                                        registerBinding.spinner2.getItemAtPosition(registerBinding.spinner2.selectedItemPosition).toString()
                                    )
                                    referneceUsuarios.push().setValue(user)
                                    val intent = Intent(this@RegisterActivity, nav_view::class.java)
                                    startActivity(intent)
                                    finish()
                                } else {
                                    Toast.makeText(
                                        baseContext,
                                        "Error al registrarse",
                                        Toast.LENGTH_SHORT,
                                    ).show()
                                }
                            } else {
                                Toast.makeText(
                                    baseContext,
                                    "Ingrese un nombre",
                                    Toast.LENGTH_SHORT,
                                ).show()
                            }
                        } else {
                            Toast.makeText(
                                baseContext,
                                "Las constraseñas incorrectas",
                                Toast.LENGTH_SHORT,
                            ).show()
                        }
                    }
            }
        }
    }

}