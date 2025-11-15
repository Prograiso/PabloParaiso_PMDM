package com.example.etiquetascoches

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.etiquetascoches.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var binding : ActivitySecondBinding

    val nombreRecuperado= intent.getStringExtra("nombre")
    val matriculaRecuperada= intent.getStringExtra("matricula")
    val anoRecuperado= intent.getStringExtra("anoMatriculacion")
    val autonomiaaRecuperada= intent.getStringExtra("autonomia")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)



        acciones()

    }

    private fun acciones() {

        binding.textNombre.text= nombreRecuperado.toString()
        binding.textMatricula.text = matriculaRecuperada.toString()
        binding.textAno.text= anoRecuperado.toString()
        binding.textautonomia.text = autonomiaaRecuperada.toString()

        //he omitido el spinner en el archivo strings no me acordé de ponerlo y no pude usarlo
        // le dejo la imagen rellena de alguna manera

        if(anoRecuperado!!.toInt()>=2015){
            binding.etiqueta.setImageResource(R.drawable.etiquetac)
        }
        else{
            binding.etiqueta.setImageResource(R.drawable.etiquetaeco)
        }
        }

    override fun onClick(v: View?) {

    }


}
