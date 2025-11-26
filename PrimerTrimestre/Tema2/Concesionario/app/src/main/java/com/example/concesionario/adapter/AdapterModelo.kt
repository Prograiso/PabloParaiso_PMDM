package com.example.concesionario.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.concesionario.R
import com.example.concesionario.model.Modelo

class AdapterModelo(var lista : ArrayList<Modelo>) : BaseAdapter() {

    override fun getCount(): Int {//cuantos elementos  tienes que pintar
        return lista.size
    }

    override fun getItem(position: Int): Modelo {//retorna el elemento en la posicion indicada
        return lista [position]
    }

    override fun getItemId(position: Int): Long {//ratorna el elemento  de la pposicion indicada
        return position.toLong()
    }

    @SuppressLint("ViewHolder")
    override fun getView(//retorna la vista ya pintada (personalizada)
        position: Int,
        convertView: View?,
        parent: ViewGroup?
    ): View? {
        val view = LayoutInflater.from(parent!!.context)
            .inflate((R.layout.item_spinner), parent,false)

        //antes de retornar la viata sacamos los elementos:
        val textoModelo : TextView = view.findViewById(R.id.nombreModelo)

        val imagenModelo : ImageView = view.findViewById(R.id.imagenModelo)

        val modelo : Modelo = lista[position]

        textoModelo.text = modelo.marca.nombre

        imagenModelo.setImageResource(modelo.marca.logo)


        return view
    }
}