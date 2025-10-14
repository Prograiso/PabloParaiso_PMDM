package model

abstract class Cliente(var id: Int,var nombre : String) {

    var factura: Double = 0.0
    var carrito: ArrayList<Producto>

    init {
        carrito = ArrayList()
    }

    open fun mostrarDatosCliente() {
        println("""
            ID: $id
            Nombre: $nombre
            Factura: $factura
        """.trimIndent())
    }







}