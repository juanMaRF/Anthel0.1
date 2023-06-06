package com.juanrivera.anthel.ui.inicio

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RegisterViewModel: ViewModel() {
    val _nombre: MutableLiveData<String> by lazy{
        MutableLiveData<String>()
    }
    fun name_(nom:String){
        _nombre.value = nom
    }
    val _correo: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    fun email_(nom:String){
        _correo.value = nom
    }
    val _genero: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    fun genere_(nom:String){
        _correo.value = nom
    }
    val _birthdate: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    fun date_(nom:String){
        _correo.value = nom
    }
    val _ciudad: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    fun city_(nom:String){
        _correo.value = nom
    }
    fun contrasprobe(con:String, con2:String):Boolean{
        var i: Boolean = false
        if(con == con2){
            if(con.length>=6){
                i=true
            }
        }else{
            i=false
        }
        return i
    }

}