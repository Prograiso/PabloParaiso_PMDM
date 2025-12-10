package com.example.productos.model

import java.io.Serializable

class Producto(
    var nombre : String,
    var precio: Int,
    var imagen: String,
    var stock : Int,
    var descripcion: String,
    var categoria: String
) : Serializable {
}

//Serializable Convierte el objeto para pasarlo entre Activities