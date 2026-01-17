package com.example.gestornotas.ui.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.gestornotas.R
import com.example.gestornotas.databinding.ActivitySecondBinding
import com.example.gestornotas.dataset.AlumnoDataSet

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initGUI()
        acciones()
    }


    fun initGUI() {
        // Configurar GUI inicial si hace falta, por ejemplo hints, textos iniciales
        binding.editNombre.hint = "Nombre"
        binding.editApellido.hint = "Apellido"
        binding.btnGuardar.text = "Guardar Alumno"
    }

    private fun acciones() {
        binding.btnGuardar.setOnClickListener {
            val nombre = binding.editNombre.text.toString()
            val apellido = binding.editApellido.text.toString()

            // validar campos vacíos
            if (nombre.isEmpty()) {
                binding.editNombre.error = "Introduce un nombre"
                return@setOnClickListener// para volver hasta que no esté vacío
            }
            if (apellido.isEmpty()) {
                binding.editApellido.error = "Introduce un apellido"
                return@setOnClickListener
            }

            //validar que sean letras
            val regex = Regex("^[A-Za-zÁÉÍÓÚáéíóúÑñ ]+$")

            if (!regex.matches(nombre)) {
                binding.editNombre.error = "El nombre solo puede contener letras"
                return@setOnClickListener
            }

            if (!regex.matches(apellido)) {
                binding.editApellido.error = "El apellido solo puede contener letras"
                return@setOnClickListener
            }

            //insertar alumno en el dataset
            AlumnoDataSet.instance.insertarAlumno(nombre,apellido)

            //cerrar y volver al main
            setResult(Activity.RESULT_OK)
            finish()
        }
    }
}


