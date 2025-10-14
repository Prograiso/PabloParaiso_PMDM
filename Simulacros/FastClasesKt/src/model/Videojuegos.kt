package model

abstract class Videojuegos(
    var titulo: String,
    var desarrollador:String,
    var anoLanzamiento:Int,
    var precio:Double,
    var clasificacion:String
) {

    open fun mostrarDatos(){
        println("titulo = ${titulo}")
        println("desarrollador = ${desarrollador}")
        println("anoLanzamiento = ${anoLanzamiento}")
        println("precio = ${precio}")
        println("clasificacion = ${clasificacion}")
    }

    abstract fun calcularPrecioFinal()
}