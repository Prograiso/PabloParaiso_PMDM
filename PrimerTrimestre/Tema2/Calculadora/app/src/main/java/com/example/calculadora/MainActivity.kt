package com.example.calculadora

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var binding: ActivityMainBinding




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }

    override fun onResume() {
        super.onResume()
        acciones()
    }


    private fun acciones(){
        binding.boton1.setOnClickListener(this)
        binding.boton2.setOnClickListener(this)
        binding.boton3.setOnClickListener(this)
        binding.boton4.setOnClickListener(this)
        binding.boton5.setOnClickListener(this)
        binding.boton6.setOnClickListener(this)
        binding.boton7.setOnClickListener(this)
        binding.boton8.setOnClickListener(this)
        binding.boton9.setOnClickListener(this)
        binding.boton0.setOnClickListener(this)
        binding.boton2ceros.setOnClickListener(this)
        binding.botondividir.setOnClickListener(this)
        binding.botonmultiplicar.setOnClickListener(this)
        binding.botonrestar.setOnClickListener(this)
        binding.botonsuma.setOnClickListener(this)
        binding.botonpunto.setOnClickListener(this)
        binding.botonigual.setOnClickListener(this)

    }

    override fun onClick(v: View?) {

        when(v!!.id){
            binding.boton1.id->
                binding.operacion.append("1") //Alternativa válida: binding.operacion.text = binding.operacion.text.toString() + "1"  es MENOS EFICIENTE CREAS UNA STRING NUEVA "1"
            binding.boton1.id->
                binding.operacion.append("2")
            binding.boton1.id->
                binding.operacion.append("3")
            binding.boton1.id->
                binding.operacion.append("4")
            binding.boton1.id->
                binding.operacion.append("5")
            binding.boton1.id->
                binding.operacion.append("6")
            binding.boton1.id->
                binding.operacion.append("7")
            binding.boton1.id->
                binding.operacion.append("8")
            binding.boton1.id->
                binding.operacion.append("9")
            binding.boton1.id->
                binding.operacion.append("0")

        }

    }



}