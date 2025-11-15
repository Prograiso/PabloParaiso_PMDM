package com.example.etiquetascoches

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.etiquetascoches.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        acciones()

    }

    private fun acciones() {

        binding.botonEnviar.setOnClickListener {  //los paso a string para evitar problemas con intet y luego el getExtra
            val nombre = binding.editNombre.text.toString()
            val matricula = binding.editMatricula.text.toString()
            val anoMatriculacion = binding.editAno.text.toString()
            val combustible = binding.spinerCombustible.selectedItemId
            val autonomia = binding.editAutonomia.text.toString()
            val intent = Intent(applicationContext, SecondActivity::class.java)
            //sé que podría crear la clase coche con los datos y pasarla como serializable en el intent la clase entera pero no me da tiempo, o eso creo

            if (nombre.isEmpty() || matricula.isEmpty() || anoMatriculacion.isEmpty() || autonomia.isEmpty()) {
                Snackbar.make(it, "por favor rellene todos los campos", Snackbar.LENGTH_LONG).show()
            }
            else {
                intent.putExtra("nombre", nombre)
                intent.putExtra("matricula", matricula)
                intent.putExtra("anoMatriculacion", anoMatriculacion)
                intent.putExtra("autonomia", autonomia)
                startActivity(intent)
            }
        }


    }

    override fun onClick(v: View?) {
        binding.spinerCombustible.onItemSelectedListener
    }
}