package org.example.`equality﻿`

/**
 * 公式サイトのequalityのURL
 * https://kotlinlang.org/docs/equality.html
 */

// 問題: Equalityについて

// 以下の各設問に答え、適切なコードを記述してください。

// 設問1:
// 2つのString型の変数 'text1' と 'text2' を宣言し、どちらも "Kotlin" という値で初期化してください。
// これらの変数が構造的に等しいかどうかを判断し、その結果をPrintlnで出力するコードを記述してください。

// 設問2:
// 'num1' をInt型で10に初期化し、'num2' を別のInt型変数として 'num1' と同じ参照を指すように初期化してください。
// これらの変数が参照的に等しいかどうかを判断し、その結果をPrintlnで出力するコードを記述してください。

// 設問3:
// Pointクラスを作成してください。このクラスは、xとyという2つのInt型のプロパティを持つようにします。
// Pointクラスにおいて、xとyの値が同じ場合に構造的等価であると判断されるように、equalsメソッドをオーバーライドしてください。
// その後、以下の2つのPointオブジェクトを作成し、構造的等価性をチェックして結果をPrintlnで出力してください。
// point1: x=5, y=10
// point2: x=5, y=10

// 設問4:
// 'valueA' を null 許容のString型で "Hello" に初期化し、'valueB' を null 許容のString型で null に初期化してください。
// 'valueA' と 'valueB' が構造的に等しいかどうかをPrintlnで出力してください。
// また、'valueB' と null が構造的に等しいかどうかをPrintlnで出力してください。

// ここに解答を記述してください。

fun main() {

    // 設問1
    // ここにコードを記述
    val text1 = "Kotlin"
    val text2 = "Kotlin"
    println(text1 == text2)

    // 設問2
    // ここにコードを記述
    val num1 = 10
    val num2 = 10
    println(num1 === num2)

    // 設問3
    // ここにコードを記述
    class Point(
        val x: Int,
        val y: Int
    ) {
        override fun equals(other: Any?): Boolean {
            if (other !is Point) return false
            return x == other.x && y == other.y
        }
    }

    val point1 = Point(x = 5, y = 10)
    val point2 = Point(x = 5, y = 10)
    println(point1 == point2)

    // 設問4
    // ここにコードを記述
    val valueA: String? = "Hello"
    val valueB: String? = null

    println(valueA == valueB)
    println(valueB == null)

}