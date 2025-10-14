package controller

import model.Arma
import model.ArmaBiologica
import model.ArmaTradicional
import model.Superheroe
import java.sql.Array
import java.util.Objects

class SHIELD {

    var superHumano = arrayOf(5)

    var listaSuperheroes = ArrayList<Superheroe>()

    var listaArmas = ArrayList<Arma>()





    fun crearSuperhumano(id:Int,nombre:String, nivel:Int, resistencia:Int):Superheroe{}




    fun listarSuperheroes(){
        for(superheroe in listaSuperheroes){
            superheroe.mostrarDatos()
    }}


    fun listarArmas(){
        for(arma in listaArmas){
            arma.mostrarDatos()
        }
    }

    fun elegirSuperheroeCombate1(id1:Int):Superheroe? {
        for (superheroe in listaSuperheroes) {
            if (superheroe.id == id1) return superheroe
        }
        return null
    }
        fun elegirSuperheroeCombate2(id2:Int):Superheroe?{
        for(superheroe in listaSuperheroes){
            if(superheroe.id == id2)  return superheroe
        }
        return null

    }



    }



