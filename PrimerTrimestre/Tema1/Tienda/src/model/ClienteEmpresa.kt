package model

class ClienteEmpresa(id: Int,
                     nombre : String,
                     var horasEntrega : String) : Cliente (id, nombre)  {

    override fun mostrarDatosCliente() {
        super.mostrarDatosCliente()
        println("horasEntrega = ${horasEntrega}")
    }


}