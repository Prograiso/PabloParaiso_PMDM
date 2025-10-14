package controller

import model.Categoria
import model.Producto
import java.util.ArrayList
import model.ProductoFisico

class ServiShop (var nombre : String? = null) {

    var caja: Double = 0.0
    var almacen : Array<ProductoFisico?>

    init{
        almacen = arrayOfNulls(5)
    }

    var carrito: ArrayList<Producto> = ArrayList()
    var factura: Double = 0.0


    //METODOS DE LA TIENDA

    //agregar producto al carrito si no hay producto con ese id
    fun agregarProductoCarrito(producto: Producto) {
        val id = producto.id ?: "id no definido"
        if (carrito.find { return@find id == producto.id } == null) {
            carrito.add(producto)
            factura += producto.precio ?: 0.0
        }else
            println("El producto con id ${producto.id} ya está en el carrito")
    }

    open fun mostrarCarrito() {
        if (carrito.isNotEmpty()) {
            carrito.forEach {
                it.mostrarDatos()
            }
        }else println("el carrito está vacío")
    }

    //realizar un metodo para mostrar la información de un producto
    // en caso de no encontrar el id -> aviso

    fun mostrarInfoProductoCarrito(id:Int){
        carrito.find { return@find it.id == id } ?.mostrarDatos()
            ?: println("No se ha encontrado el producto con id $id")
    }

    // realizar un metodo para eliminar producto/s por categoria
    // en caso de solo tener un producto -> eliminarlo
    // en caso de tener varios productos -> preguntar cuantos quiero
    // borrar
    // en caso de no tener ninguno, avisar
    fun eliminarProductoPorCategoria(categoria: String) {
        val listaFiltrada = carrito.filter { it.categoria.nombre == categoria } as ArrayList<Producto>
        when (listaFiltrada.size) {
            0 -> {
                println("No hay productos en el carrito")
            }
            1 -> {
                carrito.remove(listaFiltrada.first())
            }
            else -> {
                println("Cuantos productos quieres borrar")
                val nBorrados = readln().toInt()
                if (nBorrados == carrito.size) {
                    carrito.removeAll(listaFiltrada)
                } else if (nBorrados < carrito.size) {
                    for (i in 0 until nBorrados) {
                        carrito.remove(listaFiltrada[i])
                    }
                }
            }
        }
    }

        fun mostrarProductosAlmacen() {
            var nulos = 0
            almacen.forEach { it?.mostrarDatos() ?: nulos++ }

            if (nulos == almacen.size) println("El almacen esta vacio")
        }

        //mostrar productos filtrados por categoria, si la categoria no existe se pasa aviso
        fun mostrarPoCategoria(nombre: String?) {
            val listaFiltrada: ArrayList<Producto> = almacen.filter {
                return@filter it?.categoria?.nombre  == nombre
            } as ArrayList<Producto>

            if (listaFiltrada.isEmpty()) {
                println("No hay productos de la categoria ${nombre}")
            } else {
                listaFiltrada.forEach { it.mostrarDatos() }
            }
        }

        //añadir productos al almacen, el nuevo producto se colocará en el primer valor que sea nulo

        fun añadirProducto(item: ProductoFisico?) {
            val busquedaProducto: Producto? = almacen.find {
                return@find it?.id == item?.id
            }
            for (i in 0..almacen.size - 1) {
                if (almacen[i] == null && busquedaProducto == null) {
                    almacen[i] = item
                    println(item?.nombre + " añadido al almacen")
                    return
                }
            }
            println("No hay espacio disponible")
        }

    fun pasarPorCaja() {
        if (carrito.isNotEmpty()) {
            val total = carrito.sumOf { it.precio ?: 0.0 }
            caja += total
            carrito.clear()
            println("Compra finalizada. Se han añadido $total € a la caja. \n Total en caja: $caja €")
        } else {
            println("El carrito está vacío, no hay nada que comprar.")
        }
    }

    }
