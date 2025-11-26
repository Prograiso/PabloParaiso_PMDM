package com.example.concesionario.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.concesionario.R
import com.example.concesionario.adapter.AdapterCoche
import com.example.concesionario.databinding.ActivitySecondBinding
import com.example.concesionario.adapter.AdapterModelo
import com.example.concesionario.dataset.Dataset
import com.example.concesionario.model.Coche
import com.example.concesionario.model.Marca
import com.example.concesionario.model.Modelo

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private lateinit var marca : Marca
    private lateinit var adapterModelo : AdapterModelo
    private lateinit var listaModelos : ArrayList<Modelo>
    private lateinit var listaCoches: ArrayList<Coche>
    private lateinit var adapterCoche: AdapterCoche



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        marca = intent.getSerializableExtra("marca") as Marca
        instancias()
        initGUI()

        binding.textoModelos.append("${marca.nombre}")


        }

    private fun initGUI() {
        binding.spinnerModelo.adapter = adapterModelo
        binding.listaCoches.layoutManager =
            LinearLayoutManager(
                this,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        binding.listaCoches.adapter = adapterCoche
    }

    private fun instancias() {

        listaModelos = Dataset.getListaModelos(marca)
        adapterModelo = AdapterModelo(listaModelos)

        listaCoches = arrayListOf(
            Coche(
                Marca("Ford", R.drawable.ford),
                "Fiesta",
                20000,
                100,
                R.drawable.fiesta,
                "Este detalle es del fiesta"
            ),
            Coche(
                Marca("Ford", R.drawable.ford),
                "Focus",
                30000,
                180,
                R.drawable.focus,
                "Este detalle es del focus"
            ),
            Coche(
                Marca("Ford", R.drawable.ford),
                "Mondeo",
                40000,
                220,
                R.drawable.mondeo,
                "Este detalle es del mondeo"
            ),

        )
        adapterCoche = AdapterCoche(listaCoches, this)
    }
}