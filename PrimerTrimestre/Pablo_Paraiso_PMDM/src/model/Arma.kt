package model

abstract class Arma(
    var id:Int,
    var nombre:String,
    var potencia:Int,
    var dano:Int
) {
    open fun mostrarDatos(){
        println("id = ${id}")
        println("nombre = ${nombre}")
        println("potencia = ${potencia}")
        println("dano = ${dano}")
    }
}