class Temperatura {
    var celsius: Double = 0.0 //propiedad con getter y setter personalizados
        get() = field //devuelve el valor actual mediante field
        set(value) {
            when {
                value < -273.15 -> {
                    field = -273.15
                    println("Advertencia: La temperatura no puede ser menor que el límite.")
                    println("Temperatura en Celsius: $field")
                }
                value > 100.0 -> {
                    field = 100.0
                    println("Advertencia: La temperatura no puede ser mayor que el límite.")
                    println("Temperatura en Celsius: $field")
                }
                else -> { field = value
                println("Temperatura en Celsius: $field")
                }

            }
        }
}

fun main() {
    print("Introduce la temperatura en °C: ")
    val t = Temperatura()
    t.celsius = readln().toDouble()
}