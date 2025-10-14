package model

class ArmaBiologica(
     id:Int,
     nombre:String,
     potencia:Int,
     dano:Int,
    var descripcion:String
) : Arma(id, nombre, potencia, dano) {

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("descripcion = ${descripcion}")
    }
}