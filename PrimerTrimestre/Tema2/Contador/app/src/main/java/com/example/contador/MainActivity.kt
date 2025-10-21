package com.example.contador

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.contador.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {



    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root) //  valores grafico/logico, esta linea los junta
    }

    override fun onResume() {
        super.onResume()
        acciones()
    }

    private fun acciones() {
        binding.botonIncremento.setOnClickListener {
            Snackbar.make(it,
                "pulsado incremento",
                Snackbar.LENGTH_LONG).show()

        } 
    }
}