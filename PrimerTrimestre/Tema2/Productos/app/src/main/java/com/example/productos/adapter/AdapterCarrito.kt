package com.example.productos.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.productos.R
import com.example.productos.data.Dataset
import com.example.productos.model.Producto
import com.example.productos.ui.CarritoActivity
import com.example.productos.ui.DetalleActivity


class AdapterCarrito(
    private var listaFavoritos: ArrayList<Producto>, //1 creamos la clase con los atributos, lista y contexto
    private val context: Context
) : RecyclerView.Adapter<AdapterCarrito.Myholder>() { //3  heredamos la clase AdapterProducto con : RecyclerView.Adapter<AdapterProducto.Myholder>()


    //2 añadimos la clase anidada MyHolder con la vista:View como parametro que hereda de RecyclerView.ViewHolder
    inner class Myholder(var vista: View) : RecyclerView.ViewHolder(vista) {

        val productoImagen: ImageView = vista.findViewById(R.id.imagenProducto)
        val productoNombre : TextView = vista.findViewById(R.id.textNombreProducto)
        val botonEliminar : Button = vista.findViewById(R.id.btnEliminar)

    }

    //4 Implemento los metodos, crea el patron -> MyHolder()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Myholder {
        val binding = LayoutInflater.from(context)
            .inflate(R.layout.carrito,parent,false)
        return Myholder(vista = binding)
    }

    override fun onBindViewHolder(
        holder: Myholder,
        position: Int
    ) {
        val productoFavorito = listaFavoritos[position]
        holder.productoNombre.setText(productoFavorito.nombre)

        Glide.with(context)
            .load(productoFavorito.imagen)
            .placeholder(R.drawable.ic_launcher_foreground)
            .error(R.drawable.ic_launcher_foreground)
            .into(holder.productoImagen)


        holder.botonEliminar.setOnClickListener {
            Dataset.eliminarFavorito(productoFavorito)

        }
    }

    override fun getItemCount(): Int {
       return listaFavoritos.size
    }

}