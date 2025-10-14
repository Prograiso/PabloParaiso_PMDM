package model

class Mutante(
    id : Int,
    nombre:String,
    nivel:Int,
    var armaBiologica:Arma
) : Superheroe(id, nombre, nivel, armaBiologica) {

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("armaBiologica = ${armaBiologica}")
    }
}