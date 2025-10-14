import controller.ServiShop
import model.*

fun main() {

    val tienda = ServiShop("Paradise Shopping")


    // Productos Muebles
    val silla = ProductoFisico(1, 80.0, "Silla", "Silla de oficina", Categoria.Muebles, 1)
    val mesa = ProductoFisico(2, 120.0, "Mesa", "Mesa de comedor", Categoria.Muebles, 2)

    // Productos Ocio
    val ajedrez = ProductoOnline(3, 25.0, "Ajedrez", "Juego de ajedrez", Categoria.Ocio, 3)
    val puzzle = ProductoOnline(4, 15.0, "Puzzle", "Puzzle 1000 piezas", Categoria.Ocio, 2)

    // Productos Tecnología
    val portatil = ProductoFisico(5, 700.0, "Portátil", "Portátil ultraligero", Categoria.Tecnologia, 4)
    val auriculares = ProductoOnline(6, 60.0, "Auriculares", "Auriculares bluetooth", Categoria.Tecnologia, 1)

    // Productos Ropa
    val camiseta = ProductoFisico(7, 20.0, "Camiseta", "Camiseta algodón", Categoria.Ropa, 5)
    val gorra = ProductoOnline(8, 15.0, "Gorra", "Gorra deportiva", Categoria.Ropa, 2)

    // Productos Genérica
    val taza = ProductoFisico(9, 10.0, "Taza", "Taza personalizada", Categoria.Generica, 3)
    val llavero = ProductoOnline(10, 8.0, "Llavero", "Llavero metálico", Categoria.Generica, 1)


    var opcion = 0
    var idProducto: Int


    do{

        println(
            """
            |===============================
            |  Bienvenido a ${tienda.nombre}
            |===============================
            | 1. Mostrar productos en Almacen
            | 2. Mostrar productos por categoría
            | 3. Añadir producto al carrito
            | 4. Ver carrito
            | 5. Ver un Preoducto del carrito
            | 6. Eliminar productos por categoria
            | 7. VAgregar producto al almacen
            | 8. Pasar por Caja
            | 9. Salir
            
            |===============================
            SELECCIONA UNA POCION:
        """.trimIndent())
        opcion = readln().toInt()
        when (opcion) {
            1 -> tienda.mostrarProductosAlmacen()

            2 -> { println("Selecciona nombre de categoria:")
                var nombre = readln()
                tienda.mostrarPoCategoria(nombre) }

            3 -> tienda.agregarProductoCarrito(silla)

            4 -> tienda.mostrarCarrito()

            5 -> { println("Introduce el id del producto que quieres ver: ")
                idProducto = readln().toInt()
                tienda.mostrarInfoProductoCarrito(idProducto)}

            6 -> {println("Selecciona categoria a eliminar")
            var categoria = readln()
            tienda.eliminarProductoPorCategoria(categoria)}

            7-> tienda.añadirProducto(camiseta)

            8-> tienda.pasarPorCaja()

            9 -> println("Hasta pronto")

            else -> println("Opcion no valida")
        }
    }while (opcion!=5)
}


        //mostramos los datos de los productos de la lista:

       // listaProductos.forEach { println(it?.mostrarDatos() ?: "hueco vacio") }
        //mostrar productos de una categoria determinada

        //forma alternativa de recorrer la lista
//    for (item in listaProductos){
//        item?.mostrarProducto()
//    }

//    //cambiar a nulo el producto cuyo id sea 1
//    //para poder modificar elementos de un array, no podemos usar un foreach
//    for(i in 0.. listaProductos.size-1){
//        if (listaProductos[i]?.id == 1){
//            listaProductos[i] = null
//        }
//    }

        //aladimos productos al almacen de la tienda, llamamos a la funcion añadirProducto

//    val tienda = Tienda("PabloShop")
//    tienda.añadirProducto(gorra)
//    tienda.añadirProducto(camiseta)
//    tienda.añadirProducto(zapatillas)
//    tienda.añadirProducto(pantalon)
//    tienda.mostrarProducto()

        /*
    //algunos productos, no todos, no tienen nombre
    var nombre : String? = null

    var gafas = Producto (6 ,15.5)
    */

