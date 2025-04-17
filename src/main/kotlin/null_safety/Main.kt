package org.example.null_safety

/**
 * 公式サイト
 * https://kotlinlang.org/docs/kotlin-tour-null-safety.html
 */
fun main() {
     val nullString: String? = null
     println(describeString(nullString)) // 出力: 空文字またはnullです

     val nullString1: String? = null
     println(lengthString(nullString1)) // 出力: null

     val nullString2: String? = null
     println(nullString2?.length ?: 0) // 出力: 0

    println((1..5).sumOf { id -> salaryById(id) })
}

fun salaryById(id: Int): Int = employeeById(id)?.salary ?: 0

data class Employee(val name: String, var salary: Int)

fun employeeById(id: Int) = when (id) {
    1 -> Employee("Mary", 20)
    2 -> null
    3 -> Employee("John", 21)
    4 -> Employee("Ann", 23)
    else -> null
}

fun lengthString(maybeString: String?): Int? = maybeString?.length

fun describeString(maybeString: String?): String {
    if (!maybeString.isNullOrEmpty()) {
        return "長さ${maybeString.length}の文字列"
    } else {
        return "空文字またはnullです"
    }
}