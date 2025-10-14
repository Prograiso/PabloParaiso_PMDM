var sumaLambda: ((Int,Int) -> Int)? = {a,b -> a+b}

fun main (args:Array<String>)  {

    /*val DNI = "12345678B" //inmutable
    var nombre = "Pablo" //mutable
    var edad : Int = 34
    lateinit var correo : String

    var direccion : String? = null //puede ser nulo

    val conocimientos = arrayListOf("")

    println("Primer programa de repaso kotlin")
    correo = "paraiso@gmail.com"
    println("Hola mi nombre es $nombre y tengo $edad años" + "y mi correo es $correo")
    println("mi nombre tiene ${nombre.length*2} letras")
    println("Vivo en ${direccion ?. length?: "sin definir"}")

    println("a quien quieres saludar?")
    nombre = readln()
    println("cuantas veces quieres saludar?")
    var veces = readln().toInt()

    saludar (nombre=nombre,veces=veces)*/

    println("El resultado es ${sumaLambda?.invoke(2,3) ?: "la función es nula"}")

    sentenciaWhen(3)
    sentenciaFor()

}

fun saludar (nombre: String?=null,veces:Int? = null) {
    for (i in 0.. (veces!! -1)) {
        println("Hola $nombre")
    }
}

fun sentenciaWhen(opcion:Int) {
    when (opcion) {
        1 -> println("entrando por ejecución de caso 1")

        in 2..5 -> {
            println("entrando por ejecución de caso rango 2 a 5")
        }

        else -> {
            println("opción no contemplada")
        }
    }
} //revisar git de clase añade fun sumalamdba

fun sentenciaFor() {
   /* for (item in 0..10 step 2){
        println(item)
    }
    for (item in 10 downTo 0 step 2){ //devuelve el rango inverso
        println(item)
    }
    for (item in (10..20) step 8){ //devuelve el rango de 10 a 20 de 8 en 8
        println(item)
    }
    */

    (20..40).forEach { it : Int ->
        println(it)
    }

    (30..40).forEachIndexed{index, item -> if (index %2 ==0)
        println("el elemento en posicion par $index son $item ")  }
}


