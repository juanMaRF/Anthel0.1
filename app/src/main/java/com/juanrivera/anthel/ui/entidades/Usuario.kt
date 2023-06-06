package com.juanrivera.anthel.ui.entidades

class Usuario {
     var nombre:String = ""
     var correo:String = ""
     var genero:String = ""
     var birthdate:String = ""
     var ciudad:String = ""

    fun iniciar(name:String,email:String,genre:String,cum:String,city:String){
        var user: Usuario = Usuario()
        nombre = name
        correo = email
        genero = genre
        birthdate = cum
        ciudad = city
    }

    fun setParameters(name:String,email:String,genre:String,cum:String,city:String){
    //    var user: Usuario = Usuario()
        nombre = name
        correo = email
        genero = genre
        birthdate = cum
        ciudad = city
    }
}
