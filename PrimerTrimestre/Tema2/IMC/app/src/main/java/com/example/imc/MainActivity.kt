package com.example.imc

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.imc.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import kotlin.math.pow
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        acciones()

    }

    override fun onResume() {
        super.onResume()
        acciones()
    }

    //meter la logica, comprobar que se rellenan los campos en caso contrario snackbar, (type number permite solo numeros), asignar variables,
    // hacer el select de los radios, crear el intent con las variables, crear la clase IMC y mandarlo al second junto con el genero

    private fun acciones() {

        binding.botonCalcular.setOnClickListener {
            val peso = binding.editPeso.text.toString()
            val altura = binding.editAltura.text.toString()
            val imc : Double
            lateinit var genero : String

            when(binding.grupoRadio.checkedRadioButtonId){
                binding.radioFemenino.id-> genero = "femenino"
                binding.radioMasculino.id-> genero= "masculino"
                else -> genero = ""
            }

            if(peso.isNotEmpty() && altura.isNotEmpty() && genero.isNotEmpty()){

                imc = peso.toDouble()/ altura.toDouble().pow(2.0)

                val intent = Intent(applicationContext, SecondActivity::class.java)
                intent.putExtra("imc",imc)
                intent.putExtra("genero",genero)
                startActivity(intent)
            }
            else if(peso.isEmpty() || altura.isEmpty() || genero.isEmpty()){

                Snackbar.make(it, "Rellena todos los campos (Peso, Altura y Género)", Snackbar.LENGTH_LONG).show()
            }
        }

        binding.grupoRadio.setOnCheckedChangeListener { view, element -> //ponemos a escuchar los radiobutons

            when(element){
                binding.radioFemenino.id -> {
                    Log.v("radios", "seleccionado femenino")
                }
                binding.radioMasculino.id -> {
                    Log.v("radios", "seleccionado masculino")
                }
            }
        }

    }

    override fun onClick(id: View?) {

    }
}




