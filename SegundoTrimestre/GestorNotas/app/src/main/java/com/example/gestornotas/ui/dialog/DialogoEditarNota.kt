package com.example.gestornotas.ui.dialog

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.gestornotas.R
import com.example.gestornotas.databinding.DialogEditarNotaBinding
import com.example.gestornotas.model.Alumno


// ON ndica que es un callback que se llama cuando ocurre algo
//Editar Nota NO ejecuta el callback
//Guardar Nota desde el dialogo SI EJECUTA CALLBACK

class DialogoEditarNota(private val alumno: Alumno,
                        private val onNotaGuardada: () -> Unit
    ) : DialogFragment() {

    private lateinit var binding: DialogEditarNotaBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = DialogEditarNotaBinding.inflate(layoutInflater)

        binding.editNota.setText(alumno.nota.toString())//mostrar nota actual
        binding.editNota.setSelection(binding.editNota.text.length)//poner cursor al final para editar con setSelection()

        // Builder
        val builder = AlertDialog.Builder(requireContext())
            .setTitle("Editar nota (Máximo 4 caracteres)")
            .setView(binding.root)
            .setPositiveButton("Guardar", null) // el listener luego para que no se dierre el dialogo sin antes validar
            .setNegativeButton("Cancelar") { dialog, _ ->
                dialog.dismiss() //cierra dialogo
            }
            .setNeutralButton("Borrar nota", null)//lo mimo porque si no hago esto se sale del dialogo

        val dialog = builder.create()

        // Sobrescribir botón Guardar para añadir el listener y validar
        dialog.setOnShowListener {
            dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener {
                val texto = binding.editNota.text.toString()
                val nota = texto.toDoubleOrNull()

                if (texto.isEmpty()) {
                    binding.editNota.error = "La nota no puede estar vacía"
                    return@setOnClickListener //para no salir de setOnClickListener pero NO de onCreateDialog
                }

                if (nota == null || nota < 0.0 || nota > 10.0) {
                    binding.editNota.error = "La nota debe estar entre 0.00 y 10.00"
                    return@setOnClickListener
                }

                alumno.nota = nota
                onNotaGuardada() // refresca RecyclerView
                dialog.dismiss()
            }

            dialog.getButton(AlertDialog.BUTTON_NEUTRAL).setOnClickListener {
                binding.editNota.setText("")
            }
        }
        return dialog
    }
}