package com.example.comunidadesspinners.model

import java.io.Serializable


class ComunidadAutonoma(var nombre: String) : Serializable //Serializable Convierte el objeto para pasarlo entre Activities
{
    override fun toString(): String {
        return nombre
    }
}