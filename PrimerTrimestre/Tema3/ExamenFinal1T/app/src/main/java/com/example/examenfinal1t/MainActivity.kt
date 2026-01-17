package com.example.examenfinal1t

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.examenfinal1t.adapter.AdapterTarea
import com.example.examenfinal1t.databinding.ActivityMainBinding
import com.example.examenfinal1t.model.Tarea
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity()   {

    lateinit var binding: ActivityMainBinding
    lateinit var adapterTarea : AdapterTarea
    lateinit var listaImportancias : Array<String>
    lateinit var listaTareasporImportancia : ArrayList<Tarea>

    lateinit var imagenImportancia : String

    lateinit var listaTotalTareas :ArrayList<Tarea>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        instancias()
        initGUI()
        acciones()
    }

    private fun initGUI() {
        binding.recycleTareas.layoutManager = LinearLayoutManager(this)
        binding.recycleTareas.adapter = adapterTarea
    }

    private fun instancias() {
        listaImportancias = resources.getStringArray(R.array.importancias)
        listaTareasporImportancia= arrayListOf()
        adapterTarea = AdapterTarea(listaTareasporImportancia, context = this)
        //listaTotalTareas=binding.recycleTareas.


    }

    private fun acciones() {

        binding.spinnerimportancia.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val importancia = binding.spinnerimportancia.adapter.getItem(position).toString() // es recomendable ir al adapter no a la lista[position]
                listaTareasporImportancia=getTareasPorImportancia(importancia)
                adapterTarea.actualizarListaTareas(listaTareasporImportancia)
                when(importancia){
                    "Baja"->{imagenImportancia="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSHJqiExDSm_Qf2yXlUOuTDqjcqvisHMspMq2r8lEATMwQKAE6W0OmYfEUaaqpw9sVvvrc&usqp=CAU"}
                    "Media"->{imagenImportancia="https://static-00.iconduck.com/assets.00/medium-priority-icon-2048x2048-g3fzjdtl.png"}
                    "Alta"->{imagenImportancia="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTPsBD4_YDJYic70mveK7NbYxCYbaWa-i2Yb3KRMMGGurujXObeT8ux7UwXA5vYGMxS1-k&usqp=CAU"}
                }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }
        binding.imageButonAnadir.setOnClickListener {
            if(binding.editNombre.text.isEmpty() || binding.editDescripccion.text.isEmpty() ){
                Snackbar.make(binding.root,"Hay que rellenar todos los campos",
                    Toast.LENGTH_LONG).show()
            }
            else{
                val tarea :Tarea = Tarea(binding.editNombre.text.toString(),
                                       binding.editDescripccion.text.toString(),
                                        binding.spinnerimportancia.onItemSelectedListener.toString(),
                                        imagenImportancia)
                listaTotalTareas.add(tarea)


            }
        }


    }


    fun getTareasPorImportancia(importancia: String) : ArrayList<Tarea>{

        var tareasPorImportancia = arrayListOf<Tarea>()

        //filtramos por importancia y añadimos a la lista total
        tareasPorImportancia.addAll(listaTotalTareas.filter { it.importancia == importancia })

        return tareasPorImportancia
    }

//baja-> https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSHJqiExDSm_Qf2yXlUOuTDqjcqvisHMspMq2r8lEATMwQKAE6W0OmYfEUaaqpw9sVvvrc&usqp=CAU
//media-> https://static-00.iconduck.com/assets.00/medium-priority-icon-2048x2048-g3fzjdtl.png
//alta-> https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTPsBD4_YDJYic70mveK7NbYxCYbaWa-i2Yb3KRMMGGurujXObeT8ux7UwXA5vYGMxS1-k&usqp=CAU

}


