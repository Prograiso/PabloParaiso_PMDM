import model.Camion
import model.Coche
import model.Moto
import model.Vehiculo


fun main() {

    var ford = Coche(
       "1234ABC","Ford","Focus",
       120000,120,30000.0, 4, 450)

    var suzuki = Moto(
        "5678DEF","Suzuki","GSX",
        80000,150,15000.0,
        true,"Deportivo"
    )

    var camion = Camion( "0000DEF","Scania","mkk",
        80000,1500,15000.0, 100000.0
    )

        suzuki.mostrarDatos()
        ford.mostrarDatos()

    ford.cabeEnMaletero(500)

    val listaVehiculos: ArrayList<Vehiculo> = arrayListOf()

    listaVehiculos.add(ford)
    listaVehiculos.add(suzuki)
}