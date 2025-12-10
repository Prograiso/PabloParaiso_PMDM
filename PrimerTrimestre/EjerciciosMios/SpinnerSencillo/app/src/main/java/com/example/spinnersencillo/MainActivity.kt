package com.example.spinnersencillo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.spinnersencillo.databinding.ActivityMainBinding
import com.example.spinnersencillo.databinding.ActivitySecondBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var listaOperaciones : Array<String>

    lateinit var operacion : String
    lateinit var resultado : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        instancias()

        acciones()
    }

    private fun acciones() {
        binding.spinnerOperaciones.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                operacion = listaOperaciones[position]//aquí debería poner la logica
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }
        binding.btnOperar.setOnClickListener {
            if(binding.editxtNumero1.text.isEmpty() ||
                binding.editxtNumero2.text.isEmpty()
                )
            {
                Snackbar.make(binding.root,
                            "Introduce ambos numeros",
                            Toast.LENGTH_LONG).show()

            }
            else
            {
                var numero1 = binding.editxtNumero1.text.toString().toInt()
                var numero2 = binding.editxtNumero2.text.toString().toInt()

                when(binding.spinnerOperaciones.selectedItem){
                   "suma" -> resultado = (numero1 + numero2).toString()
                    "resta" -> resultado = (numero1 - numero2).toString()
                    "division" -> resultado = (numero1 / numero2).toString()
                    "multiplicacion" -> resultado = (numero1 * numero2).toString()
               }
                val intent : Intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("resultado",resultado)
                startActivity(intent)

            }
        }

    }


    private fun instancias() {
        listaOperaciones = resources.getStringArray(R.array.operaciones)

    }
}