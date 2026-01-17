package com.example.gestornotas

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gestornotas.adapter.AdapterAlumno
import com.example.gestornotas.databinding.ActivityMainBinding
import com.example.gestornotas.dataset.AlumnoDataSet
import com.example.gestornotas.model.Alumno
import com.example.gestornotas.ui.activities.SecondActivity
import com.example.gestornotas.ui.dialog.DialogoEditarNota


class MainActivity : AppCompatActivity() , AdapterAlumno.OnAlumnoClickListener {

    lateinit var binding: ActivityMainBinding
    lateinit var adapterAlumno: AdapterAlumno
    private  val dataSet = AlumnoDataSet.instance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.mainToolbar)

        instancias()
        initGUI()
    }

    fun instancias(){
        dataSet.inicializarSiVacio()
        adapterAlumno = AdapterAlumno(this, this)
        adapterAlumno.actualizarLista(dataSet.getAlumnos())

    }

    fun initGUI(){
        binding.recyclerAlumnos.layoutManager = LinearLayoutManager(this)
        binding.recyclerAlumnos.adapter = adapterAlumno

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean { //se selecciona en el menu insertar y vamos a la second donde insertar el alumno y volver
        return when (item.itemId) {
            R.id.menuAdd -> {
                val intent = Intent(this, SecondActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onAlumnoClick(alumno: Alumno) { //se pulsa el cardView se llama al dialogo para modificar la nota
        DialogoEditarNota(alumno) {
            adapterAlumno.notifyDataSetChanged() // refresca la lista al guardar
        }.show(supportFragmentManager, "dialogoEditarNota")
    }

    override fun onResume() {//cuando volvemos al main refrescamos la lista
        super.onResume()
        adapterAlumno.actualizarLista(dataSet.getAlumnos())
    }
}