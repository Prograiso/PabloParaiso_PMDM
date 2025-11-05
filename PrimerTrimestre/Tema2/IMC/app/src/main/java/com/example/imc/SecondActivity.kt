package com.example.imc

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.imc.databinding.ActivityMainBinding
import com.example.imc.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var binding: ActivitySecondBinding
    var imcRecuperado : Double? = null
    var generoRecuperado : String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        imcRecuperado = intent.getDoubleExtra("imc",0.0)
        generoRecuperado = intent.getStringExtra("genero")

        acciones()

        //aqui en el second extraer los datos y aplicar la logica del when para cada estado y peso y la corrspondiente imagen
        //añadir en xml los textview donde se mostrarán los resultados

        //nota, ver si pasamos solo el resultado del IMC y aquí cotejamos con los valores o pasamos todas las variables y lo calculamos aquí
    }

    private fun acciones() {
        binding.textoImc.text = imcRecuperado.toString()
        binding.textoEstado.text=""


        if(generoRecuperado=="masculino"){

            when{

                imcRecuperado!! < 18.5 -> binding.textoEstado.text = "bajo peso"
                else -> binding.textoEstado.text = "apurando"
            }

        }

        else if(generoRecuperado=="femenino"){

            when{

                imcRecuperado!! < 16.5 -> binding.textoEstado.text = "bajo peso"
                else -> binding.textoEstado.text = "apurando"
            }

        }

        if(binding.textoEstado.text== "bajo peso"){
            binding.imagen.setImageResource(R.drawable.estado1)
        }



    }


    override fun onClick(v: View?) {

    }
}