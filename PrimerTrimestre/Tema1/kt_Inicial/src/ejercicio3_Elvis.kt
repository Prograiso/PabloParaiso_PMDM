fun main (){

    println("Introduce el precio del producto:")
    var precio : Int? = readln().toIntOrNull()
    var descuento = descuento(precio)

    println("El precio base es:${precio}")
    println("El descuento es de: ${descuento}")
    println("El precio final es:~${precio * descuento /100}")

}

fun descuento (a:Int?) : Int {
    var precio: Int? = a
    var descuento = 0

    if(precio ==null  ?:100) //si precio es nulo le asigno 100

    else if (precio!!.compareTo(50)>0) 10 else 5 //si precio es mayor que 50 le aplico 10% de descuento sino 5%

        return descuento
}