package me.jazz

fun main() {

    println(calculateFee(200.0, 11_000.0))
    println(calculateFee(200.0, 11_000.0, true))
    println(calculateFee(200.0, 11_00.0, true))
    println(calculateFee(200.0, 11_00.0))

}

fun calculateFee(amount: Double, total: Double, exclusive: Boolean = false): Double {

    var fee: Int = when {
        total <= 1000 -> 30
        total <= 10000 -> 25
        else -> 20
    }

    if (exclusive) fee -= 5

    return amount * fee / 100
}