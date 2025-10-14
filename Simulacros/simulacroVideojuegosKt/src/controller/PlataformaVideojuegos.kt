package controller

import model.Videojuegos

class PlataformaVideojuegos {

    var listaVideojuegos = ArrayList<Videojuegos>()


    fun estaVideojuego(titulo:String): Videojuegos?{
        for(videojuego in listaVideojuegos){
            if(videojuego.titulo.equals(titulo, ignoreCase =true))
                return videojuego}
        return null
    }


    fun añadirJuego(videojuego: Videojuegos){
        if(estaVideojuego(videojuego.titulo)==null)
            listaVideojuegos.add(videojuego)
        else println("Videojuego ya existe")

    }
}