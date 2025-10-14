package controller

import model.Videojuegos
import model.VideojuegosAccion
import model.VideojuegosEstrategia
import model.VideojuegosRPG

class PlataformaVideojuegos() {
    var listaVideojuegos : ArrayList<Videojuegos> =ArrayList()
    var caja : Double = 0.0

    fun estaVideojuego(titulo:String):Videojuegos? {
    for (videojuego in listaVideojuegos) {
        if (videojuego.titulo.equals(titulo, ignoreCase = true)){
            return videojuego}
    }
    return  null
}

    fun mostrarDatos(){
        for(videojuego in listaVideojuegos)
            videojuego.mostrarDatos()
    }

    fun añadirVideojuego(videojuego: Videojuegos){
        if(estaVideojuego(videojuego.titulo)==null){
            listaVideojuegos.add(videojuego)
        } else{
            println("El videojuego ya está en la lista")
        }

    }

    fun eliminarVideojuego(videojuego: Videojuegos){
        if(estaVideojuego(videojuego.titulo)==null){
            println("El videojuego no existe")
        } else{ listaVideojuegos.remove(videojuego)
        println("Videojuego eliminado")}
    }

    fun ordenarJuegos() {
        listaVideojuegos.sortBy { it.precio }
        for (videojuego in listaVideojuegos) {
            println(videojuego)
        }
    }

    fun verDetallesPorIndice(indice: Int) {
        if (indice in 0 until listaVideojuegos.size) {
            println(listaVideojuegos[indice])
        } else {
            println("Índice fuera de rango.")
        }
    }

    fun filtrarVideojuegosClasificacion(clasificacion:String):List<Videojuegos>{
        return listaVideojuegos.filter { it.clasificacion.equals(clasificacion, ignoreCase = true) }
    }

    fun filtrarVideojuegosDesarrollador(desarrollador:String):List<Videojuegos>{
        return listaVideojuegos.filter { it.desarrollador.equals(desarrollador, ignoreCase = true) }
    }


    fun filtrarVideojuegoAno(ano:Int):List<Videojuegos>{
        return listaVideojuegos.filter { it.anoLanzamiento.equals(ano) }
    }

    fun calculoCaja():Double{
         var caja =0.0
        for(videojuego in listaVideojuegos){
            caja+= videojuego.precio
        }
        return caja
    }

    fun filtrarPorTipo(tipo:String) : List<Videojuegos>{
        println("Intrpduce el tipo de videojuego (accion, estrategia o rpg)")
        var tipo= readln().toString()
        return when(tipo.lowercase()){
            "accion" -> listaVideojuegos.filterIsInstance<VideojuegosAccion>()
            "estrategia" -> listaVideojuegos.filterIsInstance<VideojuegosEstrategia>()
            "rpg" -> listaVideojuegos.filterIsInstance<VideojuegosRPG>()
            else -> emptyList()
        }

    }

    }

