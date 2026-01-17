package com.example.myproyecto.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.myproyecto.R
import com.example.myproyecto.databinding.ActivityDetalleBinding
import com.example.myproyecto.model.Producto
import com.example.productos.data.Dataset

class DetalleActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetalleBinding

    private lateinit  var producto : Producto


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityDetalleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        instancias()
        getProductoDetalle()
        acciones()
        initGUI()


    }

    private fun getProductoDetalle() {
        producto = intent.getSerializableExtra("producto")as Producto
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.detalle_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menuAdd -> Dataset.getListaFavoritos(producto)
        }
        return super.onOptionsItemSelected(item)
    }

    private fun acciones() {

    }



    private fun initGUI() {

        Glide.with(this)
            .load(producto.imagen)
            .placeholder(R.drawable.ic_launcher_foreground)
            .error(R.drawable.ic_launcher_foreground)
            .into(binding.imagenProducto)

        binding.textDescripcion.setText(producto.descripcion.toString())
        binding.textnombre.setText(producto.nombre.toString())
        binding.textPrecio.setText(producto.precio.toString())
        binding.textcategoria.setText(producto.categoria.toString())
        binding.textStock.setText(producto.stock.toString())

    }

    private fun instancias() {

    }
}
