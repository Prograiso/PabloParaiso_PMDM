package model

class VideojuegosRPG(
    titulo:String?,
    desarrollador:String?,
    anoLanzamiento:Int?,
    precio:Double?,
    clasificacionEdad:String?,
    var mundoAbierto:Boolean,
    var horasHistoriaPrincipal:Int
    ) : Videojuegos(titulo, desarrollador, anoLanzamiento, precio, clasificacionEdad) {


        override fun calcularPrecioFinal(): Double {
        var precioFinal = precio ?: 0.0
        var inccremento = 0
        if(mundoAbierto) inccremento+=15
        if(horasHistoriaPrincipal>=10)     inccremento+= (horasHistoriaPrincipal/10)*2
            precioFinal += precioFinal*inccremento/100
            return precioFinal
    }

    override fun toString(): String {
        return super.toString() +
                """
                    Mundo Abierto: ${mundoAbierto}
                    Horas Historia: ${horasHistoriaPrincipal}
                """.trimIndent()
    }
}