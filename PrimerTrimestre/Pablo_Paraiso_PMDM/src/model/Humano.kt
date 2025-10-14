package model

class Humano(
     id : Int,
     nombre:String,
     nivel:Int,
    var resistencia :Int,
    var armaTradicional:Arma
):Superheroe(id, nombre, nivel,armaTradicional) {

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("resistencia = ${resistencia}")
    }
}