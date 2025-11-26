package com.example.concesionario.dataset

import com.example.concesionario.model.Marca
import com.example.concesionario.model.Modelo

class Dataset {

    companion object {

        fun getListaModelos(marca: Marca): ArrayList<Modelo> {
            val listaModelos: ArrayList<Modelo> = arrayListOf()

            when(marca.nombre){
                "Ford" ->{
                    listaModelos.add(Modelo(marca,"Mondeo"))
                    listaModelos.add(Modelo(marca,"Mondeo"))
                    listaModelos.add(Modelo(marca,"Mondeo"))
                    listaModelos.add(Modelo(marca,"Mondeo"))
                }
                "Seat" ->{
                    listaModelos.add(Modelo(marca,"Ibiza"))
                    listaModelos.add(Modelo(marca,"Arona"))
                    listaModelos.add(Modelo(marca,"Panda"))
                    listaModelos.add(Modelo(marca,"Ateca"))
                }
                "Mercedes" ->{
                    listaModelos.add(Modelo(marca,"Clase A"))
                    listaModelos.add(Modelo(marca,"Clase E"))
                    listaModelos.add(Modelo(marca,"Clase C"))
                    listaModelos.add(Modelo(marca,"Clase S"))
                }
                "Audi" ->{
                    listaModelos.add(Modelo(marca,"e tron"))
                    listaModelos.add(Modelo(marca,"A3"))
                    listaModelos.add(Modelo(marca,"A4"))
                    listaModelos.add(Modelo(marca,"A5"))
                }
            }

            return  listaModelos
        }

    }
}