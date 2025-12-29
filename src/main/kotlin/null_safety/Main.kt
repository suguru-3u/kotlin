package org.example.null_safety

/**
 * 公式サイト
 * https://kotlinlang.org/docs/kotlin-tour-null-safety.html
 */


// 第1問：基本のNull処理
//以下のコードはコンパイルエラーになります。**セーフコール（?.）とElvis演算子（?:）**を使って
// 以下の条件を満たすように修正してください。
//city が null でなければ、その文字数を変数 length に代入する。
//city が null であれば、0 を変数 length に代入する。

fun main1(){
    val city: String? = null

    // ここを修正してください
    // val length: Int = city.length
    val length: Int = city?.length ?: 0

    println(length) // 期待される出力: 0
}

//第2問：スコープ関数 let と run
//以下のコードの空欄 ( A ) と ( B ) に入る適切なスコープ関数を答えてください。

fun main2() {
    val message: String? = "Hello Kotlin"

    // ( A ) を使って、it で値を参照してプリントする
    message?.let {
        println("メッセージの長さは ${it.length} です")
    }

    // ( B ) を使って、this（省略可）でプロパティにアクセスする
    message?.run {
        println("大文字にすると ${uppercase()} です")
    }
}

//第3問：応用（コレクションとElvis）
//以下のリストには null が混ざっています。
//
//filterNotNull() を使って null を除外した新しいリストを作ってください。
//そのリストの 最初の要素（firstOrNull()） を取得し、
// もしリストが空で結果が null だったら "Unknown" という文字列を代入するようにしてください。

fun main3() {
    val names: List<String?> = listOf(null, "Alice", "Bob")

    // 1. nullを除外する
    val cleanedList = names.filterNotNull()

    // 2. 最初の要素を取り出す（nullなら "Unknown"）
    val firstName: String =  cleanedList.first()

        println(firstName) // 期待される出力: Alice
}