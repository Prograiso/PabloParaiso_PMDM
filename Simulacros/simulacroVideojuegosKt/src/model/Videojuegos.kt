package model

abstract class Videojuegos(var titulo:String?,
                           var desarrollador:String?,
                           var anoLanzamiento:Int?,
                           var precio:Double?,
                           var clasificacionEdad:String?) {




    abstract fun calcularPrecioFinal():Double


    override fun toString(): String {
        return """
            Videojuego titulo: ${titulo ?: "Sin definir"}
             desarrollador: ${desarrollador ?: "Sin definir"}
             añoLanzamiento: ${anoLanzamiento ?: "Sin definir"}
             precio: ${precio ?: "Sin definir"}
             clasificacionEdad: ${clasificacionEdad ?: "Sin definir"}
        """.trimIndent()

    }


}