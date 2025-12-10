package com.example.cambiosdepantalla

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cambiosdepantalla.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    lateinit var binding: ActivitySecondBinding

    private var nombre : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getDatosMain()
        initGUI()

    }

    private fun initGUI() {
        binding.txtViewnombre.setText(nombre).toString()
    }

    private fun getDatosMain() {
        nombre = intent.getSerializableExtra("nombre").toString()
    }
}