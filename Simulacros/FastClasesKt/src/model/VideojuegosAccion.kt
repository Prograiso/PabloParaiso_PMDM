package model

class VideojuegosAccion(
     titulo: String,
     desarrollador:String,
     anoLanzamiento:Int,
     precio:Double,
     clasificacion:String,
    var nivelViolencia:Int,
    var modoMultijugador:Boolean
) : Videojuegos(titulo, desarrollador, anoLanzamiento, precio, clasificacion) {


    override fun mostrarDatos() {
        super.mostrarDatos()
        println("nivelViolencia = ${nivelViolencia}")
        println("modoMultijugador = ${modoMultijugador}")
    }

    override fun calcularPrecioFinal() {
        TODO("Not yet implemented")
    }


}