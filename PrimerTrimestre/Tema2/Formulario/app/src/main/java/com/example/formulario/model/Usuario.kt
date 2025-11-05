package com.example.formulario.model

import java.io.Serializable

class Usuario(
    var nombre:String,
    var mail:String,
    var pass : String,
    var localizacion : String,
    var estudios: String,
    var experiencia: String
 ) : Serializable
//se pasará serializado a secondactivity