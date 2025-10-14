package model

class VideojuegosEstrategia(
    titulo:String?,
    desarrollador:String?,
    anoLanzamiento:Int?,
    precio:Double?,
    clasificacionEdad:String?,
    var complejidad : Int,
    var duracionPartida : Int
    ) : Videojuegos(titulo, desarrollador, anoLanzamiento, precio, clasificacionEdad) {

    override fun toString(): String {
        return super.toString() +
                """
                   Complejidad: ${complejidad} 
                   Duracion: ${duracionPartida} 
                """.trimIndent()
    }

    override fun calcularPrecioFinal(): Double {
        var precioFinal = precio ?: 0.0
        var incremento = 0
        if(complejidad > 0) incremento = complejidad *3
        precioFinal += precioFinal * incremento/100
        return precioFinal
    }
}