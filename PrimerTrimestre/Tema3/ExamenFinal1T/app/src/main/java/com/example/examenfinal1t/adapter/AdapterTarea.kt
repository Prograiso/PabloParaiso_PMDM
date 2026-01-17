package com.example.examenfinal1t.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.examenfinal1t.R
import com.example.examenfinal1t.model.Tarea

class AdapterTarea(private var listaTareas: ArrayList<Tarea>,private val context: Context)
    : RecyclerView.Adapter<AdapterTarea.Myholder>(){

    inner class Myholder(var vista : View) : RecyclerView.ViewHolder(vista){
        val tareaNombre : TextView = vista.findViewById(R.id.textNombreTarea)
        val tareaImagen: ImageView = vista.findViewById(R.id.imagenTarea)



    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Myholder {
        val binding = LayoutInflater.from(context)
            .inflate(R.layout.tarea,parent,false)
        return Myholder(vista = binding)
    }

    override fun onBindViewHolder(
        holder: Myholder,
        position: Int
    ) {
        val tarea = listaTareas[position]
        holder.tareaNombre.setText(tarea.nombre)

        Glide.with(context)
            .load(tarea.imagenImportancia)
            .placeholder(R.drawable.ic_launcher_foreground)
            .error(R.drawable.ic_launcher_foreground)
            .into(holder.tareaImagen)
    }

    override fun getItemCount(): Int {
        return listaTareas.size
    }

    fun actualizarListaTareas(listaActualizada: ArrayList<Tarea>) {
        listaTareas = listaActualizada
        notifyDataSetChanged()
    }


}