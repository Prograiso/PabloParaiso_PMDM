package com.example.agendajson2.ui.dialog

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class DialogAyuda : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        //1. crear un builder
        val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())

        //dialogo normal:
        //titulo:
        builder.setTitle("Selecciona una opción")
        //mensaje o lista:
        builder.setMessage("App realizada por PPS")
        //botones -> neutral             negativo/positivo
        builder.setPositiveButton("Si",{_ , _ -> // con _ , _ ahorramos trabajo al transpilador
            Log.v("dialogo", "pulsado boton Si")
        })
        builder.setNegativeButton("No",{_ , _->
            Log.v("dialogo", "pulsado boton No")
        })
        builder.setNeutralButton("Cancelar",{view,pos->
            Log.v("dialogo", "pulsado boton Cancelar")
        })




        //dialogo personalizado (hay que configurar una vista)

        //2. creo el dialogo (lo retornamos)
        return builder.create()
    }
}