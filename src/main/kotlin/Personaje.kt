package org.example

import kotlin.random.Random

class Personaje(val nombre: String, val vida: Int = Random.nextInt(60,180), val ataque: Int = Random.nextInt(5,100)) {

    var vidaActual : Int = vida


    fun attack(pjToAttack: Personaje): Int{
        if (hasDied()){
            return 0
        }

        val damage = calculateDamage()
        pjToAttack.receiveDamage(damage)
        return damage
    }



    fun calculateDamage(): Int {

        val reducedDamage = ataque * (1 - (vidaActual.toDouble() / vida))

        return ataque - reducedDamage.toInt()

    }


    fun receiveDamage(damage: Int){
        vidaActual -= damage
        // if (hasDied) vidaActual = 0
    }

    fun dieCase(): String {
        if (hasDied()){
            return when (vidaActual) {
                in -10..0 -> " A $nombre no se le puede reconocer"
                in -20..-10 -> " $nombre ha quedado hecho trizas"
                in -49..-20 -> " $nombre ha sido borrado de la existencia"
                else -> "El universo a sido borrado"
            }
        }
        return ""
    }

    fun hasDied(): Boolean{
        return vidaActual <= 0
    }


}