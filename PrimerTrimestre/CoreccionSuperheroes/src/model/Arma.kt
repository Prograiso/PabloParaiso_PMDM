package model

abstract class Arma(id:Int,nombre:String,var potencia:Int, var dano:Int) {

    open fun mostrarDatos(){
        println("potencia = ${potencia}")
        println("dano = ${dano}")
        println("javaClass = ${javaClass}")
    }
}