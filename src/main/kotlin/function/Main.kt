package org.example.function

import kotlin.math.PI

/**
 * 公式サイト
 * https://kotlinlang.org/docs/kotlin-tour-functions.html
 */

fun main() {
    println(circleArea(2))
    println(intervalInSeconds(hours = 2, minutes = 40, seconds = 0))

    val actions = listOf("title", "year", "author")
    val prefix = "https://example.com/book-info"
    val id = 5
    val urls = createUrlList(actions = actions, prefix = prefix, id = id)
    urls.forEach(::println)

    repeatN(5) { println("Hello") }
}

fun repeatN(n: Int, action: () -> Unit) {
    repeat(n) { action() }

}

fun createUrlList(
    actions: List<String>,
    prefix: String,
    id: Int
): List<String> = actions.map { "$prefix/$id/$it" }


fun circleArea(radius: Int = 0): Double = radius * radius * PI

fun intervalInSeconds(hours: Int = 0, minutes: Int = 0, seconds: Int = 0): Int =
    ((hours * 60) + minutes) * 60 + seconds