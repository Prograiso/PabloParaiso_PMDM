package model

class VideojuegosRPG(
    titulo: String,
    desarrollador:String,
    anoLanzamiento:Int,
    precio:Double,
    clasificacion:String,
    var mundoAbierto:Boolean,
    var horasHistoria:Int
) : Videojuegos(titulo, desarrollador, anoLanzamiento, precio, clasificacion),Coleccionable {

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("mundoAbierto = ${mundoAbierto}")
        println("duracionPartida = ${horasHistoria}")
    }

    override fun calcularPrecioFinal() {
        TODO("Not yet implemented")
    }

    override fun incrementarValor() {
        precio *= 1.05
    }
}