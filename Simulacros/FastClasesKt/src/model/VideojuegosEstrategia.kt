package model

class VideojuegosEstrategia(
    titulo: String,
    desarrollador:String,
    anoLanzamiento:Int,
    precio:Double,
    clasificacion:String,
    var complejidad:Int,
    var duracionPartida:Int
) : Videojuegos(titulo, desarrollador, anoLanzamiento, precio, clasificacion),Coleccionable {


    override fun mostrarDatos() {
        super.mostrarDatos()
        println("complejidad = ${complejidad}")
        println("duracionPartida = ${duracionPartida}")
    }

    override fun calcularPrecioFinal() {
        TODO("Not yet implemented")
    }

    override fun incrementarValor() {
        TODO("Not yet implemented")
    }


}