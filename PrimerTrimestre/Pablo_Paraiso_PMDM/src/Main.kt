import controller.SHIELD
import model.Arma
import model.ArmaBiologica
import model.ArmaTradicional
import model.Superheroe


fun main(){

    var shield = SHIELD()

        var opcion : Int

        do{
            println("""
                ===== MENU =====
                OPCION 1: Crear superheroe
                OPCION 2: Listar superheroes
                OPCION 3: Listar armas
                OPCION 4: Crear combate y mostrar ganador
                OPCION 0: SALIR Y CERRAR
            """.trimIndent())

            println("Introduce una opcion:")
            opcion= readln().toInt()

            when(opcion){
                1-> println("no me ha salido")

                2-> if(shield.listaSuperheroes.isEmpty()){
                    println("La lista está vacía")}
                else{
                    shield.listarSuperheroes()}

                3-> if(shield.listaArmas.isEmpty()){
                    println("La lista está vacía")}
                else{
                    shield.listarArmas()}

                4->

                shield.elegirSuperheroeCombate1()

                0-> println("Adiós")

                else -> println("opcion no válida")
            }

        }while(opcion!=0)



    var superMutante = arrayOf(Int,String,)


    //TRADICIONALES
    var martillo = ArmaTradicional(1, "miolmir", 10, 95,100)
    var escudo = ArmaTradicional(2, "escudoCapi", 8, 85,20)
    var guantelete = ArmaTradicional(3, "guanteInfinito", 12, 10,10)

    //BIOLOGICAS
    var veneno = ArmaBiologica(1,"venenoExtremis", 9,90, "Un suero biotecnológico que mejora las capacidades físicas y de regeneración")
    var virus = ArmaBiologica(2,"virusCarnage", 10,95, "Un virus basado en el simbionte Carnage, capaz de controlar el cuerpo y la mente de la víctima")
    var suero = ArmaBiologica(3,"sueroSoldado", 8,85, "Un suero diseñado para crear soldados perfectos, otorgando fuerza sobrehumana y resistencia")



    }
