package com.juanrivera.anthel.ui.inicio

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel() {
    val email: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val pass: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun correo(Email:String){
        email.value = Email
    }

    fun compro(correo:String, contra:String): String {
        var resp = ""
        if (correo.isEmpty()){
            resp="Email vacio."
        }else if(contra.isEmpty()){
            resp = "Contraseña vacia."
        }else if(correo.isEmpty() && contra.isEmpty()){
            resp="Espacios vacios."
        }
        return resp
    }
}