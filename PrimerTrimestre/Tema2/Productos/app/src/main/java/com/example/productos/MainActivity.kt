package com.example.productos

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.productos.adapter.AdapterProducto
import com.example.productos.data.Dataset
import com.example.productos.databinding.ActivityMainBinding
import com.example.productos.model.Producto
import com.example.productos.ui.CarritoActivity

class MainActivity : AppCompatActivity(), AdapterProducto.OnProducctoListener {
lateinit var binding: ActivityMainBinding
lateinit var adapterProducto: AdapterProducto
lateinit var listaCategorias: Array<String>
lateinit var listaProductosPorCategoria : ArrayList<Producto>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        instancias()
        initGUI()
        acciones()
    }
    //pintar el menu en la parte superior derecha
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){

            R.id.menuCarrito->{
                val intent: Intent = Intent(this, CarritoActivity::class.java)
                startActivity(intent)
            }
            R.id.menuLimpiar->{Dataset.listaFavoritos.clear()}
        }
        return super.onOptionsItemSelected(item)
    }

    private fun instancias() {
        //el array de categorías del recurso strings.xml
        listaCategorias= resources.getStringArray(R.array.categorias)
        // Inicializamos la lista con todos los productos (por defecto, categoría "Todas")
        listaProductosPorCategoria = Dataset.getProductosPorCategoria("Todas")
        // Inicializamos el Adapter con la lista actual
        adapterProducto = AdapterProducto(listaProductosPorCategoria, context = this)

    }

    private fun acciones() {

        binding.spinnerCategoria.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val categoria = binding.spinnerCategoria.adapter.getItem(position).toString() // es recomendable ir al adapter no a la lista[position]
                listaProductosPorCategoria = Dataset.getProductosPorCategoria(categoria)
                adapterProducto.actualizarListaProductos(listaProductosPorCategoria)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

    }

    private fun initGUI() {
        binding.recycleProductos.layoutManager = LinearLayoutManager(this)
        binding.recycleProductos.adapter = adapterProducto

    }

    override fun onCompraProductoSelected() {
        binding.textoCarrito.text = Dataset.listaFavoritos.size.toString()
    }
}

