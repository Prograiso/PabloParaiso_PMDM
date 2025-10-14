package model

enum class Categoria(var nombre:String, var iva:Double) {

    Muebles("muebles", 0.1),
    Ocio("ocio", 0.21),
    Tecnologia("tecnologia", 0.2),
    Ropa("ropa", 0.3),
    Generica("Sin categoria", 0.5)



}