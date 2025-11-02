package com.example.formulario

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.formulario.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar


class SecondActivity : AppCompatActivity(), View.OnClickListener {





    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        acciones()



    }

    private fun acciones() {


    }

    override fun onClick(v: View?) {

    }


}