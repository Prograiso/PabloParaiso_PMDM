package com.example.agendajson2

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager

import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.agendajson2.adapter.AdapterUsuario
import com.example.agendajson2.databinding.ActivityMainBinding
import com.example.agendajson2.model.Usuario
import com.example.agendajson2.ui.dialog.DialogAyuda
import com.google.gson.Gson
import org.json.JSONArray
import org.json.JSONObject
import kotlin.math.log


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var adapterUsuario: AdapterUsuario

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.mainToolbar)

        instancias()
        initGUI()
        acciones()

        realizarPeticionJSON()
    }

    private fun realizarPeticionJSON() {
        val url = "https://dummyjson.com/users"
        //1 crear la peticion
        val request: JsonObjectRequest = JsonObjectRequest(
            url,
            { procesarRespuesta(it) },
            { Log.v("Error", "Error en la conexión") })
        //añadir a la cola de peticiones
        Volley.newRequestQueue(applicationContext).add(request)
    }


    private fun procesarRespuesta(param: JSONObject) {
        val gson: Gson = Gson()
        val usuariosJSONArray: JSONArray = param.getJSONArray("users")

        for (user in 0..usuariosJSONArray.length() - 1) {
            val usuarioJSON: JSONObject = usuariosJSONArray.getJSONObject(user)

            val usuario: Usuario = gson.fromJson(
                usuarioJSON.toString(),
                Usuario::class.java
            )
            adapterUsuario.addUser(usuario)

            Log.v("conexion", usuario.firstName.toString())
        }
    }


//hay que sacar los usuarios en el recycler con un card view por usuario con su adapter


    private fun acciones() {

    }

    private fun initGUI() {
        binding.recyclerUsuarios.adapter=adapterUsuario
        binding.recyclerUsuarios.layoutManager =
            LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL,
                false)

    }

    private fun instancias() {
            adapterUsuario = AdapterUsuario(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }
//DEBERES HACER FILTRO EN EL MENU POR GENERO O MASCULINOS O FEMENINOS
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){

            R.id.menuFiltrar ->{

            }

            R.id.menuAyuda ->{
                val dialogAyuda = DialogAyuda()
                dialogAyuda.show(supportFragmentManager, null)
            }

        }
        return super.onOptionsItemSelected(item)
    }



}
