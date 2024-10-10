package org.example


fun main() {


    /*
    val random1 = Random.nextInt(5,50)
    val random2 = Random.nextInt(5,50)

    println(random1)
    println(random2)
*/
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