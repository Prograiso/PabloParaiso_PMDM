import controller.PlataformaVideojuegos
import model.VideojuegosAccion
import model.VideojuegosEstrategia
import model.VideojuegosRPG



    fun main(){

        var plataforma = PlataformaVideojuegos()

        var juego1 = VideojuegosAccion("yeeyee", "yeyegames",2020,50.55, "pegi15",5,  true)
        var juego2 = VideojuegosAccion("tuctuc", "tucgames",2010,90.95, "pegi18",5,  false)

        var juego3 = VideojuegosEstrategia("nazination", "nazigames",1946,150.55, "pegi18",1,  750)
        var juego4 = VideojuegosEstrategia("boby", "bobygames",2010,10.55, "pegi3",3,  250)

        var juego5 = VideojuegosRPG("hitman", "bmgames",2025,500.55, "pegi16",false,  365)
        var juego6 = VideojuegosRPG("loko", "lokogames",2011,20.55, "pegi13",true,  555)





        do{
            println("""
                ===== MENU =====
                OPCION 1: Mostrar los juegos
                OPCION 2: Añadir juego
                OPCION 3: Eliminar juego
                OPCION 0: SALIR DEL MENU
            """.trimIndent())
            var opcion = readln().toInt()
            when(opcion){

                1-> plataforma.mostrarDatos()
                2-> plataforma.añadirVideojuego(juego4)
                3-> plataforma.eliminarVideojuego(juego4)
                0 -> println("adios")
                else-> println("opcion no valida")
            }
        } while (opcion!=0)

    }
