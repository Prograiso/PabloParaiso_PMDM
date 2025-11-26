package com.example.concesionario.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.concesionario.R
import com.example.concesionario.databinding.ItemCocheBinding
import com.example.concesionario.model.Coche

//2- indico el tipado del Adapter como la clase inner

class AdapterCoche (var lista : ArrayList<Coche>, var contexto : Context) : RecyclerView.Adapter<AdapterCoche.MyHolder>(){

    //1- creo la clase anidada
    inner class MyHolder(var vista: View): RecyclerView.ViewHolder(vista){
        val textoPrecio: TextView = vista.findViewById(R.id.textPrecioCoche)
        val imagenCoche: ImageView = vista.findViewById(R.id.imagenMarca)
        val botonDetalle : Button = vista.findViewById(R.id.btndetalle)
    }

    //3- Implemento los metodos
    override fun onCreateViewHolder( //crea la plantilla de todas las filas
        parent: ViewGroup,
        viewType: Int
    ): MyHolder {
        val binding =LayoutInflater.from(contexto).inflate(R.layout.item_coche, parent,false,)
        return MyHolder(binding)
    }

    override fun onBindViewHolder( //asocia la plantilla con el elemento de la posicion
        holder: MyHolder,
        position: Int
    ) {
        val coche = lista[position]
        holder.textoPrecio
        holder.imagenCoche
        holder.botonDetalle
    }

    override fun getItemCount(): Int { // indica cuantos elementos se representan en la plantilla
        return lista.size
    }



}