package com.example.gestornotas.dataset

import com.example.gestornotas.model.Alumno

class AlumnoDataSet {

    private val alumnos = mutableListOf<Alumno>()

    fun getAlumnos(): MutableList<Alumno> {
        return alumnos
    }

    fun inicializarSiVacio() {
        if (alumnos.isEmpty()) {
            for (i in 1..10) {
                alumnos.add(
                    Alumno(
                        nombre = "Alumno",
                        apellido = "$i",
                        nota = 0.0
                    )
                )
            }
        }
    }

    fun insertarAlumno(nombre: String, apellido: String) {
        alumnos.add(
            Alumno(
                nombre = nombre,
                apellido = apellido,
                nota = 0.0
            )
        )
    }

    companion object {
        val instance= AlumnoDataSet()
    }
}