package me.jazz

import kotlin.math.roundToInt

fun main() {
    val height = 1.76
    val weight = 80.0

    val index = bodyMassIndex(height, weight )
    val verdict = when {
        (index <= 16) -> "Выраженный дефицит массы тела"
        (index <= 18.5) -> "Недостаточная (дефицит) масса тела"
        (index <= 24.99) -> "Норма"
        (index <= 30) -> "Избыточная масса тела (предожирение)"
        (index <= 35) -> "Ожирение"
        (index <= 40) -> "Ожирение резкое"
        else -> "Очень резкое ожирение"
    }
    println(verdict)

    println("Границы Вашего нормального веса:" + calculateBodyNormalMass(height).toString())
}

fun bodyMassIndex(height :Double, weight : Double) : Double {
    return weight / (height * height)
}

fun calculateBodyNormalMass(height :Double) : Pair<Int, Int> {
    val minWeight = 18.5 * (height * height)
    val maxWeight = 24.99 * (height * height)
    return Pair(
        minWeight.roundToInt(),
        maxWeight.roundToInt()
    )
}