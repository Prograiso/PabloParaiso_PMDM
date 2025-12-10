package com.example.concesionario.ui

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
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
        acciones()

        binding.textoModelos.append("${marca.nombre}")
        }

    private fun acciones(){

        binding.spinnerModelo.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val modeloSeleccionado : Modelo = parent!!.adapter.getItem(position) as Modelo
                listaCoches= Dataset.getModelo(modeloSeleccionado);
                adapterCoche.notifyDataSetChanged()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }
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

        listaCoches =
            Dataset.getModelo(Modelo(Marca("Ford", 1),"Fiesta"))

        adapterCoche = AdapterCoche(listaCoches, this)
    }
}