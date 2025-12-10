package com.example.comunidadesspinners

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.comunidadesspinners.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        instancias()
        initGUI()
        acciones()

    }

    private fun acciones() {
        TODO("Not yet implemented")
    }

    private fun initGUI() {
        TODO("Not yet implemented")
    }

    private fun instancias() {
        TODO("Not yet implemented")
    }
}