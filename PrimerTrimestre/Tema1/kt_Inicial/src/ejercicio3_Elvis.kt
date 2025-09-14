

fun main() {
    println("Introduce el precio del producto:")
    val precio: Int? = readln().toIntOrNull() ?: 100
    val descuento = calcularDescuento(precio)
    val precioBase = precio ?: 100
    val precioFinal = precioBase - descuento

    println("El precio base es: $precioBase")
    println("El descuento aplicado es: $descuento")
    println("El precio final es: $precioFinal")
}

fun calcularDescuento(precio: Int?): Double {
    val precioBase = precio ?: 100
    val porcentaje = if (precioBase > 50) 10 else 5
    return precioBase * porcentaje / 100.0
}