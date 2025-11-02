package com.example.contador

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.contador.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() , View.OnClickListener {



    lateinit var binding: ActivityMainBinding
     var contador: Int =0


    override fun onCreate(savedInstanceState: Bundle?) { //en esta funcion se guardan los estados del ciclo de vida

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root) //  valores grafico/logico, esta linea los junta

        contador= savedInstanceState?.getInt("contador")?: 0 //esto recupera el valor de contador
        binding.textoContador.text = contador.toString() //esto lo pone en el textocontador


    }

    override fun onResume() {
        super.onResume()
        acciones()
    }

    private fun acciones() {

        binding.botonDecremento.setOnClickListener (this)
        binding.botonIncremento.setOnClickListener(this)
        binding.botonReset?.setOnClickListener(this) //este boton puede ser null xk solo esta en horizontal (land)
    }

    override fun onClick(v: View?) {
        //id
        when (v!!.id) {

            binding.botonIncremento.id -> {
                //sumar 1 al texto
                contador++
            }

            binding.botonDecremento.id -> {
                //restar 1 al texto
                contador--
            }

            binding.botonReset!!.id -> {
                if (binding.edittext!!.text.isNotEmpty()) {
                    contador = binding.edittext!!.text.toString().toInt()
                    binding.edittext!!.text.clear()
                } else binding.edittext?.hint="INTRODUCE NUMERO"
            }
        }
        binding.textoContador.text = contador.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) { // en esta funcion se guarda el contador para mantenerlo cuando se reinicie la app
        super.onSaveInstanceState(outState)

        outState.putInt("contador", binding.textoContador.text.toString().toInt())

    }
}
