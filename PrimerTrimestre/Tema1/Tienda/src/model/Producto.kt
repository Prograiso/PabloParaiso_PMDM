package model

abstract class Producto(var id: Int?,
               var precio: Double? = 10.0,
               var nombre: String? = null,
               var descripcion: String? = null,
               var categoria: Categoria = Categoria.Ropa) {



open fun mostrarDatos(){

        println("""
            ID: ${id ?: "sin definir"} 
            Precio: ${precio ?: "sin definir"}
            Nombre: ${nombre ?: "sin definir"}
            Descripción: ${descripcion ?: "sin definir"}
            Categoria: ${categoria.nombre}
        """.trimIndent())
}

}