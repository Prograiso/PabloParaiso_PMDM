fun main (){
/*
    //ejercicio 1 if else
    println("Introduce un numero:")
    var numero = readln().toInt()
    ejercicio1ParImpar(numero)

    //ejercicio 2 if else if
    println("Introduce un número: ")
    var numero2 = readln().toInt()
    ejercicio2PositivoNegativoCero(numero2)


    //ejercicio3 for
    println("Introduce un número: ")
    var numero3 = readln().toInt()
    ejercicio3primoFor(numero3)

    //ejercicio4 for
    println("Introduce un número: ")
    var numero4 = readln().toInt()
    ejercicio4PrimosMenorIgual(numero4)

    //ejercicio5 for
    println("Introduce un número: ")
    var numero5 = readln().toInt()
    ejercicio5Factorial(numero5)

    //ejercicio6 for
    println("Introduce un número: ")
    var numero6 = readln().toInt()
    ejercicio6Naturales(numero6)*/

    //ejercicio7 for
    println("Introduce un número: ")
    var numero7 = readln().toInt()
    ejercicio7SumaDigitos(numero7)


}



//metodos

fun ejercicio1ParImpar(num:Int) {
   var parImpar : String
    if (num%2 ==0) parImpar = "par"
    else parImpar = "impar"
      println("El numero $num es $parImpar")
}

fun ejercicio2PositivoNegativoCero(num:Int){
    var posNegCero : String
    if(num > 0) posNegCero = "positivo"
    else if (num < 0) posNegCero = "negativo"
    else posNegCero = "cero"
    println("El numero $num es $posNegCero")
}


fun ejercicio3primoFor(num:Int){
    var numero = num
    var divisor = 0

    for(i in 1 ..  numero) {
        if (numero % i == 0) divisor++
    }
    if(divisor ==1 || divisor>2) println("El numero $numero no es primo")
    else println("El numero $numero es primo")

}
//Escribe un programa que lea un número entero
// y que muestre por pantalla todos los números primos
// menores o iguales al número leído.

fun ejercicio4PrimosMenorIgual(num:Int) {
    var numero = num
    for (n in 1..numero) {
        var divisor = 0
        for (i in 1..n) {
            if (n % i == 0) divisor++
        }
        if (divisor == 2) println("El numero $n es primo")

    }

}

fun ejercicio5Factorial(num:Int){
    var numero = num
    var factorial =1
   for (i in 1..numero){
       factorial *= i
   }
    println("El factorial de $numero es $factorial")
}

fun ejercicio6Naturales (num:Int){
 var numero = num
    var sumaNaturales=0
    for( i in 0 ..numero){
        sumaNaturales+= i
    }
    println("la suma de los Numeros Naturales de $numero es $sumaNaturales")
}

fun ejercicio7SumaDigitos(num:Int){
    var numero = num

   for(i in 1.. numero.toString().length){

   }

}


