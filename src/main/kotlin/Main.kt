package org.example

fun main() {
    val eleccion = readln().toInt()

    when(eleccion){
        1-> ej1()
        2-> ej2()
        3-> {
            var danio = 0f
            for (i in 1..3){
                println("Dime el daño de ataque: ")
                val dan = readln().toInt()
                danio += ej3(dan)
            }
            println("El daño total de los 3 ataques es $danio")
        }
        4-> ej4()
        5-> ej5()
        6-> {
            print("Dime tu daño de ataque: ")
            val ataque = readln().toInt()
            val dano = ej6(ataque)
            println("Daño infligido: $dano")
        }
        7-> ej7()
        8-> ej8()
        9-> ej9()
        10-> ej10()
    }
}


fun ej1(){
    println("Hola mundo!")
}

fun ej2(){
    var vida = 100
    println("La vida del personaje es $vida")
}

fun ej3(num : Int): Int{
    return num * 5
}

fun ej4(){
    var monedas = 0
    for (i in 1..10){
        println("Iteracion $i, $monedas monedas")
        monedas += 5
    }
}

fun ej5(){
    print("Dime el nivel de tu personaje: ")
    val nivel = readln().toInt()
    when(nivel){
        in 0..10 -> println("Personaje principiante")
        in 10..20 -> println("Personaje intermedio")
        in 20..30 -> println("Personaje avanzado")
        else -> println("Nivel no permitido")
    }
}

fun ej6(ataque: Int): Int{
    return if (ataque > 50) {
        println("¡Golpe crítico!")
        ataque * 2
    } else {
        ataque
    }
}

fun ej7() {

    val characters = listOf<Personaje>(
        Personaje("Fran"),
        Personaje("Paco")
    )

    val first = characters.random()

    val second : Personaje


    if (first == characters[0]){
        second = characters[1]
    }else {
        second = characters[0]
    }

    var turn = 1

    while (!first.hasDied() && !second.hasDied()){
        println("Turno $turn !!!!")

        println(" ${first.nombre} ataca hace ${first.attack(second)} de daño")
        println(" ${second.nombre} ataca hace ${second.attack(first)} de daño")

        println(" A ${first.nombre} le quedan ${first.vidaActual} puntos de vida y a ${second.nombre} le quedan ${second.vidaActual}")



        println(first.dieCase() + second.dieCase())

        turn++
    }
}


fun ej8() {
    val pj = Personaje("Fran")
    var opcion: Int

    do {
        println("\n--- Inventario ---")
        println("1. Añadir objeto")
        println("2. Eliminar objeto")
        println("3. Mostrar inventario")
        println("4. Salir")
        print("Elige una opción: ")
        opcion = readln().toInt()

        when (opcion) {
            1 -> {
                print("Introduce el nombre del objeto a añadir: ")
                val objeto = readln()
                pj.addToInv(objeto)
                println("$objeto ha sido añadido al inventario.")
            }
            2 -> {
                print("Introduce el nombre del objeto a eliminar: ")
                val objeto = readln()
                pj.removeFromInv(objeto)
            }
            3 -> {
                pj.showItems()
            }
            4 -> println("Saliendo del inventario...")
            else -> println("Opción no válida, por favor elige otra.")
        }
    } while (opcion != 4)
}

fun ej9(){
    val pj = Personaje("fran")
    pj.winBattle()
    pj.winBattle()
    pj.winBattle()
    pj.winBattle()
    pj.winBattle()
    pj.winBattle()
    pj.winBattle()
    pj.winBattle()
}

fun ej10(){
    val enemigo = Personaje("Enemigo", vida = 500)

    val equipo = listOf(
        Personaje("Guerrero"),
        Personaje("Mago"),
        Personaje("Arquero"),
        Personaje("Asesino")
    )

    println("Comienza la batalla contra el enemigo con ${enemigo.vidaActual} de vida")

    while (enemigo.vidaActual > 0) {
        var danoTotal = 0

        for (miembro in equipo) {
            val dano = miembro.attack(enemigo)
            danoTotal += dano
            println("${miembro.nombre} inflige $dano de daño al enemigo.")
        }

        println("El equipo ha infligido un total de $danoTotal de daño.")
        println("La vida actual del enemigo es ${enemigo.vidaActual}.")

        if (enemigo.hasDied()) {
            println("¡El enemigo ha sido derrotado!")
            println(enemigo.dieCase())
            break
        }
    }
}