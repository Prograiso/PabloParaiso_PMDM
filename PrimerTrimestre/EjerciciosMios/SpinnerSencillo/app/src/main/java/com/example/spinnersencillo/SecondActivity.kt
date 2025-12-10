package com.example.spinnersencillo

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.spinnersencillo.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    lateinit var binding: ActivitySecondBinding
    var resultado : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getResultado()
        initGUI()

    }

    private fun initGUI() {
        binding.txtViewResultado.setText(resultado).toString()
    }

    private fun getResultado() {
        resultado = intent.getStringExtra("resultado").toString()
    }


}