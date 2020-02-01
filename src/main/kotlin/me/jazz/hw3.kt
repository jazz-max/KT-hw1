package me.jazz

fun main() {

    val tests = listOf<Long>(30L,31L,32L,35L)

    tests.forEach {
        println(pluralTimeAgo(it))
        println(pluralTimeAgo(it * 60))
        println(pluralTimeAgo(it * 3600))
        println(pluralTimeAgo(it * 3600 * 24))
        println(pluralTimeAgo(it * 3600 * 24 * 7))
        println(pluralTimeAgo(it * 3600 * 24 * 365))
    }
}

fun pluralTimeAgo(seconds: Long): String {
    val n: Long
    return when {
        seconds < 60 -> {
            String.format("%d %s", seconds, pluralN(seconds, "секунда", "секунды", "секунд"))
        }
        seconds < 3600 -> {
            n = seconds / 60
            String.format("%d %s", n, pluralN(n, " минута", " минуты", " минут"))
        }
        seconds < 3600 * 24 -> {
            n = seconds / 60 / 60
            String.format("%d %s", n, pluralN(n, " час", " часа", " часов"))
        }
        seconds < 3600 * 24 * 7 -> {
            n = seconds / 3600 / 24
            String.format("%d %s", n, pluralN(n, " день", " дня", " дней"))
        }
        seconds < 3600 * 24 * 60 -> { // до 2х мес переводим в недели
            n = seconds / 3600 / 24 / 7
            String.format("%d %s", n, pluralN(n, " неделя", " недели", " недель"))
        }
        seconds < 3600 * 24 * 365 -> {
            n = seconds / 3600 / 24 / 30
            String.format("%d %s", n, pluralN(n, " месяц", " месяца", " месяцев"))
        }
        else -> {
            n = seconds / 60 / 60 / 24 / 365
            String.format("%d %s", n, pluralN(n, " год", " года", " лет"))
        }
    } + " назад"
}

fun pluralN(n: Long, one: String, twofor: String, many: String): String {
    var number: Long = n
    if (number > 20) number = n % 10
    return when (number) {
        1L -> one
        2L, 3L, 4L -> twofor
        else -> many
    }
}
