package com.example.gestornotas.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gestornotas.databinding.ItemAlumnoBinding
import com.example.gestornotas.model.Alumno


class AdapterAlumno (var contexto: Context,
                     private val listener: OnAlumnoClickListener) :
    RecyclerView.Adapter<AdapterAlumno.Myholder>(){
    private val lista = ArrayList<Alumno>  ()
    interface OnAlumnoClickListener {// INTERFAZ para click en alumno
        fun onAlumnoClick(alumno: Alumno)

    }

    inner class Myholder(var binding: ItemAlumnoBinding):
            RecyclerView.ViewHolder(binding.root){

            }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Myholder {
        val binding = ItemAlumnoBinding.inflate(LayoutInflater.from(
            contexto),parent,false)
        return Myholder(binding)
    }

    override fun onBindViewHolder(
        holder: Myholder,
        position: Int
    ) {
        val alumno = lista[position]
        holder.binding.cardAlumno.setOnClickListener{listener.onAlumnoClick(alumno)}//para clickar en el cardview
        holder.binding.toolbarUsuario.title = "Gestionar nota: Alumno ${position + 1}"
        holder.binding.tvNombre.text="${alumno.nombre} ${alumno.apellido}"
        holder.binding.tvNota.text= "Nota: " + "${alumno.nota}"
    }

    override fun getItemCount(): Int {
        return  lista.size
    }


    //actualizar toda la lista
    fun actualizarLista(nuevaLista: List<Alumno>) {
        this.lista.clear()
        this.lista.addAll(nuevaLista)
        println("DEBUG: La lista ahora tiene ${lista.size} alumnos")
        notifyDataSetChanged()
    }
}

