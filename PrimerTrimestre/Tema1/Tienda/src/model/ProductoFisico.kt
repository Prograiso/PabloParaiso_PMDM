package model

class ProductoFisico (id: Int?,
                      precio: Double? = 10.0,
                      nombre: String? = null,
                      descripcion: String? = null,
                      categoria: Categoria = Categoria.Ropa,
                      var pasilloAlmacen : Int
) : Producto (id, precio, nombre, descripcion, categoria){


    override fun mostrarDatos() {
        super.mostrarDatos()
        println("pasilloAlmacen = ${pasilloAlmacen}")
    }
}