package com.example.practicacalculadora

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewbinding.ViewBinding
import com.example.practicacalculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var binding: ActivityMainBinding
    var resultado = binding.resultado.text.toString().toDouble()
    var operacion = binding.resultado.text.toString()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityMainBinding.inflate(layoutInflater)//esta linea manda
        setContentView(binding.root)//esta linea manda

        resultado= savedInstanceState?.getDouble("resultado")?: 0.0
        operacion= savedInstanceState?.getString("operacion")?: ""

        binding.operacion.text=""
        binding.resultado.text="0.0"

        var resultado = binding.resultado.text.toString().toDouble()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putDouble("reultado",resultado)
        outState.putString("opeacion",operacion)
    }

    private fun acciones(){

        //portview
        binding.botonSuma.setOnClickListener(this)
        binding.botonResta.setOnClickListener(this)
        binding.botonDiv.setOnClickListener(this)
        binding.botonMulti.setOnClickListener(this)
        binding.botonOff.setOnClickListener(this)
        binding.botonAC.setOnClickListener(this)
        binding.botonC.setOnClickListener(this)
        binding.botonIgual.setOnClickListener(this)
        binding.botonPunto.setOnClickListener(this)
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

        //landscape + portview
        binding.botonRaiz?.setOnClickListener(this)
        binding.botonPow?.setOnClickListener(this)
        binding.botonSeno?.setOnClickListener(this)
        binding.botonCoseno?.setOnClickListener(this)

    }

    override fun onResume() {
        super.onResume()
        acciones()

    }
// aquí seguramente si fuera mas grande el proyecto podría crear listas de botones numericos y botones de operacion para manejarlos mas facilmente
    override fun onClick(vista: View?) {

        when(vista!!.id){

            binding.boton1.id,binding.boton2.id,binding.boton3.id,
            binding.boton4.id,binding.boton5.id,binding.boton6.id,
            binding.boton7.id,binding.boton8.id,binding.boton9.id,
            binding.boton0.id,binding.botonPunto.id-> botonNumerico(vista as Button)

            binding.botonSuma.id,binding.botonResta.id,binding.botonMulti.id,
            binding.botonDiv.id-> botonOperacion(vista as Button)

            binding.botonC.id-> binding.operacion.text = ""

            binding.botonAC.id-> limpiarTodo(vista as Button)

            binding.botonOff.id -> finish()

            binding.botonIgual.id->{ if(binding.operacion.text.isNotEmpty()){
                                    var resultado = operar(binding.operacion.text.toString())
                                    binding.resultado.text = resultado.toString()
                                    }
                                    else  null
                                    }


        }
    }

    //metodos botones

    private fun botonNumerico(botonpulsado: Button){
        var numero = botonpulsado.text
        binding.operacion.append(numero)  //append añade siempre al final
    }

    private fun botonOperacion(botonpulsado: Button){
        var signo = botonpulsado.text
        var ultimoChar = binding.operacion.text.last().toString() 
                if(binding.operacion.text.isNotEmpty()){
                    if(ultimoChar != "-" && ultimoChar != "+" && ultimoChar != "/" && ultimoChar!= "*" && ultimoChar!= "√")
                    binding.operacion.append(signo)
                }
                else null
    }

    private fun raizCuadrada (botonpulsado: Button){
        if (operacion.isEmpty())
        {
            operacion="√" //vamos a escribir en op el caracter cuando este vacio y luego este se reemplazará por el math así en todos
        }
    }

    private fun seno (botonpulsado: Button){

    }

    private fun coseno (botonpulsado: Button){

    }

    private fun potencia(botonpulsado: Button){

    }

    private fun limpiarTodo(botonpulsado: Button){
        binding.operacion.text=""
        binding.resultado.text="0.0"
    }

    private fun operar(texto: String): Double {

        val numRegex = Regex("(\\d*\\.?\\d+)") //para encontrar los numeros pos neg o decimales
        val opRegex = Regex("[\\-+*/]")  // para encontrar los operadores, incluidos los que dan signo a los numeros +5 -6...

        //meter los todos numeros y operadores encontrados en operacion en posiciones de listas mutables
        val numeros = numRegex.findAll(texto).map { it.value }.toMutableList()
        val operadores = opRegex.findAll(texto).map { it.value }.toMutableList()


        // multiplicaciones y divisiones primero (de izquierda a derecha)
        var i = 0
        while (i < operadores.size) { //esta condicion se sigue cumpliendo porque se han eliminado operadores al hacer los calculos
            if (operadores[i] == "*" || operadores[i] == "/") {
                val n1 = numeros[i].toDouble()
                val n2 = numeros[i+1].toDouble()
                val resultado = if (operadores[i] == "*") n1 * n2 else n1 / n2
                // Reemplaza el primer número por el resultado
                numeros[i] = resultado.toString()
                // Elimina el segundo número y el operador de la lista
                numeros.removeAt(i+1)//borra el segundo numero, queda el primero(resultado)
                operadores.removeAt(i)//borra el operador utilizado
            } else {
                i++   //i++ para cuando el operador no es / o * pasar al siguiente operador
            }
        }

        // Procesa sumas y restas después (de izquierda a derecha)
        i = 0
        while (i < operadores.size) {
            val n1 = numeros[i].toDouble()
            val n2 = numeros[i+1].toDouble()
            val resultado = if (operadores[i] == "-") n1 - n2 else  n1 + n2
            numeros[i] = resultado.toString()
            numeros.removeAt(i+1)
            operadores.removeAt(i)
        }
        // El único número que queda es el resultado final en la posicion 0, no quedan operadores
        return numeros[0].toDouble()
    }


}