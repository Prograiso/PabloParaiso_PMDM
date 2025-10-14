package model

class Coche(matricula: String,
     marca: String,
     modelo: String,
     km: Int,
     cv: Int,
     precio: Double,
    var puertas : Int,
    var capacidadmaletero : Int) : Vehiculo(matricula, marca, modelo, km, cv, precio), Coleccionable {


        override fun mostrarDatos() {
        super.mostrarDatos()
            println("puertas = ${puertas}")
            println("capacidadmaletero = ${capacidadmaletero}")
    }

    fun cabeEnMaletero(elemento:Int){
        if(elemento > capacidadmaletero){
            println("Si entra en maletero")
        } else {
            println("No entra en maletero")
        }
    }

    override fun incrementarValor() {
        println("Vamos a ver como te coleccionas")
        precio*=1.10 // se incrementa un 10%
    }
}