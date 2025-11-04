package com.example.formulario

import android.content.Context
import android.content.Intent
import android.icu.lang.UCharacter.GraphemeClusterBreak.V
import android.os.Bundle
import android.util.Log
import android.util.Log.v
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.formulario.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {  //se usa solo para guardar datos si la activiti(app)  se gira la pantalla o se destruye y recrea la Activity por el sistema.
        super.onCreate(savedInstanceState)     //pero no se usa para cambiar de activiti durante el funcionamiento de la app, para pasar datos entre activities usamos Intent y putextra()

        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        acciones()

    }

    private fun acciones(){

        binding.botonEnviar.setOnClickListener {
            val nombre = binding.editNombre.text.toString()
            val mail = binding.editMail.text.toString()
            val pass = binding.editMail.text.toString()
            val experiencia = binding.checkBoxExperiencia.isChecked
            lateinit var cantidadExperiencia : String
            if(experiencia){
                when(binding.grupoRadio.checkedRadioButtonId){
                    binding.radioCinco.id-> cantidadExperiencia = "menos de 5"
                    binding.radioMasCinco.id -> cantidadExperiencia = "mas de 5"
                }
            }
            val intent: Intent = Intent(applicationContext, SecondActivity::class.java)

            //deberes si no hay datos rellenos al pulsar enviar, mensaje que faltan datos, experiencia puede estar vacia
            //si estan todos los datos bien relleno pasar a secondmain y mostrar mensaje de enhorabuena borja , pista se hace con bundle
            if(nombre.isEmpty()||mail.isEmpty()||pass.isEmpty()||(cantidadExperiencia.isEmpty() && experiencia))
            {
                Snackbar.make(binding.root, "Por favor introduce datos", Snackbar.LENGTH_SHORT).show()
            }
            else
            {
                intent.putExtra("nombre",nombre)
                intent.putExtra("mail",mail)
                intent.putExtra("pass", pass)
                intent.putExtra("experiencia", experiencia)
                intent.putExtra("cantidadexp", cantidadExperiencia)
                startActivity(intent)
            }

        }
        binding.checkBoxExperiencia.setOnCheckedChangeListener {view,state ->
            binding.radioCinco.isEnabled= state
            binding.radioMasCinco.isEnabled= state
            binding.grupoRadio.check(-1)//el menos 1 indica que no hay seleccion
        }
        binding.grupoRadio.setOnCheckedChangeListener { view, element ->
            when(element){
                binding.radioCinco.id ->{
                    Log.v("radio5","ni puta idea")
                }
                binding.radioMasCinco.id -> {
                    Log.v("radioMasDe5", "pero que ni puta idea")
                }
            }
        }
        binding.spinnerPuesto.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Log.v("spinner", binding.spinnerPuesto.selectedItem.toString())
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Log.v("spinner", binding.spinnerPuesto.selectedItem.toString())
            }
        }

    }




    override fun onClick(v: View?) {

    }
}