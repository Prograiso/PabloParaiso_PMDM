package model

class Humano(
     id:Int,
     nombre:String,
     nivel:Int,
    ) : SuperHeroe(id, nombre, nivel) {

    var armaTradicional :ArmaBiologica? =null
}