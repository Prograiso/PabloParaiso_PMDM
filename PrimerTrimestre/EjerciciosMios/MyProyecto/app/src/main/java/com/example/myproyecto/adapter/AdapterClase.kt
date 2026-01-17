
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.example.myproyecto.R

import com.example.myproyecto.model.Producto
import com.example.myproyecto.ui.DetalleActivity
import com.example.productos.data.Dataset

class AdapterProducto(private var listaProductos: ArrayList<Producto>,
                      private val context: Context) //1 creamos la clase adapter con los atributos
    : RecyclerView.Adapter<AdapterProducto.Myholder>(){//3 tipamos. heredamos la clase AdapterProducto con  : RecyclerView.Adapter<AdapterProducto.Myholder>()

    private lateinit var listener : OnProducctoListener
    init {
        listener = context as OnProducctoListener
    }

    //2 añadimos la clase anidada MyHolder con la vista:View como parametro que hereda de RecyclerView.ViewHolder
    inner class Myholder(var vista : View) : RecyclerView.ViewHolder(vista){
        val productoImagen: ImageView = vista.findViewById(R.id.imagenProducto)
        val productoNombre : TextView = vista.findViewById(R.id.textNombreProducto)
        val botonDetalle : Button = vista.findViewById(R.id.btndetalle)
        val botonAdd : Button = vista.findViewById(R.id.btnaddProducto)

    }
    //4 Implemento los metodos, crea el patron -> MyHolder()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Myholder {
        val binding = LayoutInflater.from(context)
            .inflate(R.layout.producto,parent,false)
        return Myholder(vista = binding)
    }

    override fun onBindViewHolder(
        holder: Myholder,
        position: Int
    ) {
        val producto = listaProductos[position]
        holder.productoNombre.setText(producto.nombre)

        Glide.with(context)
            .load(producto.imagen)
            .placeholder(R.drawable.ic_launcher_foreground)
            .error(R.drawable.ic_launcher_foreground)
            .into(holder.productoImagen)


        holder.botonDetalle.setOnClickListener {
            val intent = Intent (context, DetalleActivity :: class.java)
            intent.putExtra("producto",producto)
            context.startActivity(intent)

        }

        holder.botonAdd.setOnClickListener {
            Dataset.getListaFavoritos(producto)
            listener.onCompraProductoSelected()

        }
    }

    override fun getItemCount(): Int {

        return listaProductos.size
    }

    fun actualizarListaProductos(listaActualizada: ArrayList<Producto>) {
        listaProductos = listaActualizada
        notifyDataSetChanged()
    }

    interface OnProducctoListener{
        fun onCompraProductoSelected()
    }


}