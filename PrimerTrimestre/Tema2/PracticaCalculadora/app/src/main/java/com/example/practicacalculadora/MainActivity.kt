package com.example.practicacalculadora

import android.annotation.SuppressLint
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
import kotlin.math.cos
import kotlin.math.pow
import kotlin.math.sin

import kotlin.math.sqrt

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var binding: ActivityMainBinding
    var resultado = 0.0
    var operacion = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)//estas lineas mandan
        setContentView(binding.root)

        resultado = savedInstanceState?.getDouble("resultado") ?: 0.0
        operacion = savedInstanceState?.getString("operacion") ?: ""

        binding.operacion.text = operacion
        binding.resultado.text = resultado.toString()

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putDouble("resultado", binding.resultado.text.toString().toDouble())
        outState.putString("operacion", binding.operacion.text.toString())
    }

    private fun acciones() {

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


        when (vista!!.id) {

            binding.boton1.id, binding.boton2.id, binding.boton3.id,
            binding.boton4.id, binding.boton5.id, binding.boton6.id,
            binding.boton7.id, binding.boton8.id, binding.boton9.id,
            binding.boton0.id, binding.botonPunto.id -> botonNumerico(vista as Button)

            binding.botonSuma.id, binding.botonResta.id, binding.botonMulti.id,
            binding.botonDiv.id -> botonOperacion(vista as Button)

            binding.botonC.id -> binding.operacion.text = ""

            binding.botonAC.id -> limpiarTodo(vista as Button)

            binding.botonOff.id -> finish()

            binding.botonIgual.id -> pulsarIgual(vista as Button)

            binding.botonCoseno?.id, binding.botonPow?.id,
            binding.botonSeno?.id, binding.botonRaiz?.id -> botonCiencitico(vista as Button)


        }
    }

    //metodos botones
    private fun botonNumerico(botonpulsado: Button) {
        var numero = botonpulsado.text
        binding.operacion.append(numero)  //append añade siempre al final
    }


    private fun botonOperacion(botonpulsado: Button) {
        var signo = botonpulsado.text

        if (binding.operacion.text.isNotEmpty()) {
            val ultimoChar = binding.operacion.text.last().toString()
            if ((ultimoChar != "-" && ultimoChar != "+" && ultimoChar != "/" && ultimoChar != "*" && ultimoChar != "√")
                && (!operacion.contains("sen") &&
                        !operacion.contains("cos") &&
                        !operacion.contains("pow"))
            ) {
                binding.operacion.append(signo)
            }
        } else if (operacion.isEmpty()) null
    }

    private fun pulsarIgual(botonpulsado: Button) {

        operacion = binding.operacion.text.toString()
        val ultimoChar = if (operacion.isNotEmpty()) {
            binding.operacion.text.last().toString()
        } else {
            ""
        }

        if (binding.operacion.text.contains("pow")) {
            val base = binding.operacion.text.toString().substringBefore("pow").toDoubleOrNull()
            val exponente = binding.operacion.text.toString().substringAfter("pow").toDoubleOrNull()
            if (base != null && exponente != null) {
                binding.resultado.text = base.pow(exponente).toString()
            }
        } else if (binding.operacion.text.isNotEmpty() &&
            (ultimoChar != "-" && ultimoChar != "+" && ultimoChar != "/" && ultimoChar != "*" && ultimoChar != "√")
        ) {
            var resultado = operar(binding.operacion.text.toString())
            binding.resultado.text = resultado.toString()
        } else if (operacion.isEmpty()) null
    }


    private fun botonCiencitico(botonpulsado: Button) {

        if (binding.operacion.text.isNotEmpty() &&
            binding.operacion.text.none { it in setOf('+', '-', '*', '/', '√') } &&
            !binding.operacion.text.contains("sen") &&
            !binding.operacion.text.contains("cos") &&
            !binding.operacion.text.contains("pow")
        ) {
            val numero = binding.operacion.text.toString()
                .toDouble() //si se cumple el if es que solo hay un numero y se pasa a double

            when (botonpulsado.id) {
                binding.botonRaiz!!.id -> {
                    binding.operacion.text = "√$numero"
                    binding.resultado.text = sqrt(numero).toString()
                }

                binding.botonSeno!!.id -> {
                    binding.operacion.text = "sen$numero"
                    binding.resultado.text = sin(numero).toString()
                }

                binding.botonCoseno!!.id -> {
                    binding.operacion.text = "cos$numero"
                    binding.resultado.text = cos(numero).toString()
                }

                binding.botonPow!!.id -> {
                    binding.operacion.text = "${numero}pow"
                    binding.resultado.text = ""
                }
            }
        }
    }


    private fun limpiarTodo(botonpulsado: Button) {
        binding.operacion.text = ""
        binding.resultado.text = "0.0"
    }

    private fun operar(texto: String): Double {

        val numRegex = Regex("(\\d*\\.?\\d+)") //para encontrar los numeros pos neg o decimales
        val opRegex =
            Regex("[\\-+*/]")  // para encontrar los operadores, incluidos los que dan signo a los numeros +5 -6...

        //meter los todos numeros y operadores encontrados en operacion en posiciones de listas mutables
        val numeros = numRegex.findAll(texto).map { it.value }.toMutableList()
        val operadores = opRegex.findAll(texto).map { it.value }.toMutableList()


        //multiplicaciones y divisiones primero (de izquierda a derecha)
        var i = 0
        while (i < operadores.size) { //esta condicion se sigue cumpliendo porque se han eliminado operadores al hacer los calculos
            if (operadores[i] == "*" || operadores[i] == "/") {
                val n1 = numeros[i].toDouble()
                val n2 = numeros[i + 1].toDouble()
                val resultado = if (operadores[i] == "*") n1 * n2 else n1 / n2
                // Reemplaza el primer número por el resultado
                numeros[i] = resultado.toString()
                // Elimina el segundo número y el operador de la lista
                numeros.removeAt(i + 1)//borra el segundo numero, queda el primero(resultado)
                operadores.removeAt(i)//borra el operador utilizado
            } else {
                i++   //i++ para cuando el operador no es / o * pasar al siguiente operador
            }
        }

        //sumas y restas después (de izquierda a derecha)
        i = 0
        while (i < operadores.size) {
            val n1 = numeros[i].toDouble()
            val n2 = numeros[i + 1].toDouble()
            val resultado = if (operadores[i] == "-") n1 - n2 else n1 + n2
            numeros[i] = resultado.toString()
            numeros.removeAt(i + 1)
            operadores.removeAt(i)
        }
        // El único número que queda es el resultado final en la posicion 0, no quedan operadores
        return numeros[0].toDouble()
    }


}