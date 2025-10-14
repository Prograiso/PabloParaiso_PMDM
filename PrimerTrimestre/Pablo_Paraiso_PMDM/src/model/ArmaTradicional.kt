package model

class ArmaTradicional(
     id:Int,
     nombre:String,
     potencia:Int,
     dano:Int,
    var peso: Int,
) : Arma(id, nombre, potencia, dano){

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("peso = ${peso}")
    }
}