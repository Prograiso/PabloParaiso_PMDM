fun main (args:Array<String>)  {

    val DNI = "12345678B" //inmutable
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

    saludar (nombre=nombre,veces=veces)
    //sumaLambda(2,3)

}

fun saludar (nombre: String?=null,veces:Int? = null) {
    for (i in 0.. (veces!! -1)) {
        println("Hola $nombre")
    }
}


//var sumaLambda: (Int,Int) -> Int =

