package com.example.productos.ui

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.productos.MainActivity
import com.example.productos.R
import com.example.productos.adapter.AdapterCarrito
import com.example.productos.data.Dataset
import com.example.productos.databinding.ActivityCarritoBinding
import com.example.productos.databinding.ActivityDetalleBinding
import com.example.productos.model.Producto
import com.google.android.material.snackbar.Snackbar

class CarritoActivity : AppCompatActivity() {

   lateinit var binding : ActivityCarritoBinding

   lateinit var listafavoritos : ArrayList<Producto>

   lateinit var adapterCarrito : AdapterCarrito



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCarritoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        instancias()
        initGUI()
        acciones()



    }

    //pintar el menu en la parte superior derecha
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.carrito_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){

            R.id.menuVaciar->{
                listafavoritos.clear()
                val intent : Intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            R.id.menuTotal->{
                Snackbar.make(binding.recycleCarrito,"El carrito contiene ${listafavoritos.size} productos",
                    Toast.LENGTH_LONG).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun acciones() {

    }

    private fun initGUI() {
        binding.recycleCarrito.layoutManager= LinearLayoutManager(this)
        binding.recycleCarrito.adapter = adapterCarrito
    }

    private fun instancias() {
        listafavoritos = Dataset.getListaCarrito()
        adapterCarrito = AdapterCarrito(listafavoritos, context = this)

    }
}