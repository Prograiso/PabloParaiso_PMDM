package model

class ProductoOnline( id: Int?,
                      precio: Double? = 10.0,
                      nombre: String? = null,
                      descripcion: String? = null,
                      categoria: Categoria = Categoria.Ropa,
                      var diasEntrega : Int
) : Producto (id, precio, nombre, descripcion, categoria) {

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("diasEntrega = ${diasEntrega}")
    }
}