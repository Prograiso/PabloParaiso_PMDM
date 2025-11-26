package com.example.concesionario

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.concesionario.databinding.ActivityMainBinding
import com.example.concesionario.model.Marca
import com.example.concesionario.ui.SecondActivity


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapterMarcas : ArrayAdapter<Marca>
    private lateinit var  listaMarcas: ArrayList<Marca>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instancias()
        initGui()
        acciones()
        }

    private fun acciones() {
        binding.spinnerMarcas.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val marcaSeleccionada : Marca = binding.spinnerMarcas.adapter.getItem(position) as Marca
                binding.imagenMarca.setImageResource(marcaSeleccionada.logo)

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }

        binding.btnConsultar.setOnClickListener {

            val intent = Intent (this, SecondActivity::class.java)

            intent.putExtra("marca",binding.spinnerMarcas.selectedItem as Marca)
            startActivity(intent)
        }
    }

    private fun initGui() {
        binding.spinnerMarcas.adapter = adapterMarcas
        adapterMarcas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
    }

    private fun instancias() {
        listaMarcas = arrayListOf(
            Marca("Ford",R.drawable.ford),
            Marca("Seat",R.drawable.seat),
            Marca("Audi",R.drawable.audi),
            Marca("Mercedes",R.drawable.mercedes),
            Marca("VW",R.drawable.vw))

        adapterMarcas = ArrayAdapter(applicationContext,
            android.R.layout.simple_spinner_item,
            listaMarcas)
    }
}
