package model

class ClienteParticular( id: Int,
                         nombre : String,
                            var dni : String) : Cliente (id, nombre) {

    fun mostrarProducto() {
        super.mostrarDatosCliente()
        println("dni = ${dni}")
    }
}