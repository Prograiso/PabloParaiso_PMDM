package com.example.agendajson2.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.agendajson2.R
import com.example.agendajson2.databinding.ItemUsuarioBinding
import com.example.agendajson2.model.Usuario

//2- indico el tipado del Adapter como la clase inner
class AdapterUsuario(var contexto : Context) :
    RecyclerView.Adapter<AdapterUsuario.Myholder>(){

        private lateinit var lista : ArrayList<Usuario>

        init {
            lista = ArrayList<Usuario>()
        }





    //1- creo la clase anidada
    inner class Myholder(var binding: ItemUsuarioBinding):
        RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder( //crea la plantilla de todas las filas
        parent: ViewGroup,
        viewType: Int
    ): Myholder {
        val binding = ItemUsuarioBinding.inflate(LayoutInflater.from(contexto),
            parent,false)
        return Myholder(binding)
    }


    override fun onBindViewHolder(//asocia la plantilla con el elemento de la posicion
        holder: Myholder,
        position: Int
    ) {
        val usuario = lista[position]
        holder.binding.toolbarUsuario.title = usuario.gender
        holder.binding.tvEmail.text = usuario.email.toString()
        holder.binding.tvName.text = "${usuario.firstName} ${usuario.lastName}"
        Glide.with(contexto).load(usuario.image).into(holder.binding.imageUser)


    }

    override fun getItemCount(): Int { // indica cuantos elementos se representan en la plantilla
        return lista.size
    }

    fun addUser(usuario: Usuario){
        this.lista.add(usuario)
        notifyItemInserted(lista.size-1)
    }
}