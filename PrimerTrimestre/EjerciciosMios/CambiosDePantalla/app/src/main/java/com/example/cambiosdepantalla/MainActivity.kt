package com.example.cambiosdepantalla

import android.content.Intent
import android.os.Bundle
import android.util.Log.v
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cambiosdepantalla.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        acciones()
        instancias()
        initGUI()

    }

    private fun acciones() {
        binding.btnEnviar.setOnClickListener{
            val nombre = binding.textNombre.text.toString()
            if(binding.textNombre.text.isNotEmpty()){
                val intent : Intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("nombre", nombre)
                startActivity(intent)
            }
            else{
                Snackbar.make(
                    binding.root,
                    "EL nombre está vacío",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    private fun initGUI() {

    }

    private fun instancias() {

    }


}