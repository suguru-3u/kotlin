package org.example.control_flow

/**
 * 公式サイト
 * https://kotlinlang.org/docs/kotlin-tour-control-flow.html
 * https://kotlinlang.org/docs/control-flow.html#for-loops
 */

fun main() {
    problem1()
    problem2()
    filterAndPrint(listOf(1, 2, 3, 4, 5, 6))

    val grid = listOf(
        listOf(1, 2, 3, 4, 5),
        listOf(6, 7, 8, 9, 10),
        listOf(11, 12, 13, 14, 15),
        listOf(16, 17, 18, 19, 20),
        listOf(21, 22, 23, 24, 25)
    )
    searchGrid(grid)

    getUserNameLength(User("test"))
}

fun filterAndPrint(listNum: List<Int>) {
    listNum.forEach { value ->
        // 5の処理をスキップしているだけ
        if (value == 5) return@forEach
        println(value)
    }
}

fun searchGrid(grid: List<List<Int>>) {
    outer@ for (row in grid) {
        for (value in row) {
            if (value == 10) {
                println("Found 10 at value: $value")
                break@outer
            }
        }
    }
}

data class User(val name: String?)

fun getUserNameLength(user: User?) {
    val name = user?.name ?: return
    println(name.length)
}

fun mainIf() {
    val trueNum = 1
    val falseNum = 2
    val check = true

    // 通常のif文
    if (check) {
        println(trueNum)
    } else {
        println(falseNum)
    }

    // 省略したif分
    println(if (check) trueNum else falseNum)

    // 変数に格納できるif文
    val inputIf = readlnOrNull()
    val result1 = if (inputIf == "Hello") {
        "Hello"
    } else {
        inputIf
    }
    println(inputIf)
}

fun mainWhen() {
    // When(引数は省略できる)
    val inputWhen = "When"
    val result2 = when (inputWhen) {
        "When" -> "正解"
        else -> "不正解"
    }
    println(result2)

    val result3 = when {
        inputWhen == "When" -> "正解"
        else -> "不正解"
    }
    println(result3)
}

fun mainFor() {
    // for文
    for (number in 1..5) {
        println(number)
    }

    // 順番飛ばし
    for (number in 1..6 step 2) {
        println(number)
    }

    // 逆順
    for (number in 4 downTo 1) {
        println(number)
    }

    // 文字
    for (char in 'a'..'c') {
        println(char)
    }

    // 配列
    val cakes = listOf("carrot", "cheese", "chocolate")
    for (cake in cakes) {
        println(cake)
    }

    // indexを取得するfor文
    for ((index, value) in cakes.withIndex()) {
        println(index)
        println(value)
    }

    for (i in cakes.indices) {
        println(i)
        println(cakes[i])
    }

    cakes.forEachIndexed { index, value ->
        println(index)
        println(value)
    }

    // while文
    var cakesEaten = 0
    while (cakesEaten < 3) {
        println("Eat a cake")
        cakesEaten++
    }
}

/**
 * Write a program that simulates the Fizz buzz game. Your task is to print numbers from 1 to 100 incrementally,
 * replacing any number divisible by three with the word "fizz",
 * and any number divisible by five with the word "buzz".
 * Any number divisible by both 3 and 5 must be replaced with the word "fizzbuzz".
 */
fun problem1() {
    for (i in 1..100) {
        val num5 = i % 5 == 0
        val num3 = i % 3 == 0
        val result = when {
            num5 && num3 -> "fizzbuzz"
            num5 -> "buzz"
            num3 -> "fizz"
            else -> i
        }
        println(result)
    }
}

/**
 * You have a list of words.
 * Use for and if to print only the words that start with the letter l.
 */
fun problem2() {
    val words = listOf("dinosaur", "limousine", "magazine", "language")
    for (word in words) {
        if (word.startsWith("l")) {
            println(word)
        }
    }
    words.filter { it.startsWith("l") }.forEach { println(it) }
}