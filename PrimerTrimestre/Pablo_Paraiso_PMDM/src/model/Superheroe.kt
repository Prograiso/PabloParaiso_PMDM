package model

abstract class Superheroe(
    var id : Int,
    var nombre:String,
    var nivel:Int,
    var arma :Arma
) {

    open fun mostrarDatos(){
        println("id = ${id}")
        println("nombre = ${nombre}")
        println("nivel = ${nivel}")
        println("arma = ${arma}")
    }

}