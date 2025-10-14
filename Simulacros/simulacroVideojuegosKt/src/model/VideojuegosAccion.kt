package model

class VideojuegosAccion(
     titulo:String?,
     desarrollador:String?,
     anoLanzamiento:Int?,
     precio:Double?,
     clasificacionEdad:String?,
     var nivelViolaencia : Int,
     var modoMultijugador : Boolean

     ) : Videojuegos(titulo, desarrollador, anoLanzamiento, precio, clasificacionEdad) {


         override fun calcularPrecioFinal(): Double {
            var precioFinal = precio ?: 0.0
              if(nivelViolaencia>3) precioFinal *= 1.05
             if(modoMultijugador) precioFinal*=10
             return precioFinal
            }

    override fun toString(): String {
        return super.toString() +
                """
                     Nivel Violencia: ${nivelViolaencia}
                     Modo Multijugador: ${modoMultijugador}
                """.trimIndent()
    }
}