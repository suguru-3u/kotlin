package org.example.extension_function_拡張関数

/**
 * 練習問題：注文管理システムのユーティリティ拡張
 * あなたは、ECサイトの注文管理システムを開発しています。 以下の2つの仕様を満たす拡張関数を実装してください。
 *
 * 仕様1：金額表示のフォーマット（Int型の拡張）
 * Int 型（金額）を、日本円の記号（¥）と3桁区切りのカンマが付いた文字列に変換する拡張関数 toYenFormat を作成してください。
 *
 * 例: 1500.toYenFormat() -> "¥1,500"
 *
 * 例: 3000000.toYenFormat() -> "¥3,000,000"
 *
 * 仕様2：リストの要約（List<String>型の拡張）
 * List<String> 型（商品名のリストなど）を、特定のルールで1つの文字列にまとめる拡張関数 summarize を作成してください。
 *
 * ルール:
 *
 * リストが空の場合は "商品なし" と返す。
 *
 * リストに要素がある場合は、先頭の要素を取り出し、その後に「外○点」と付け加える。
 *
 * 例: listOf("りんご", "みかん", "バナナ").summarize() -> "りんご 外2点"
 *
 * 例: listOf("ペン").summarize() -> "ペン 外0点"
 *
 * 例: emptyList<String>().summarize() -> "商品なし"
 */

fun Int.toYenFormat(): String {
    val mark = "¥"
    val dot = ","
    val strInt = this.toString()
    if (strInt.length < 3) return mark + strInt

    val reversedStr = strInt.reversed()
    var sum = ""

    for ((index, value) in reversedStr.withIndex()) {
        if(index > 2 && index % 3 == 0){
            sum = dot + sum
        }
        sum = value + sum
    }
    return mark + sum
}

fun List<String>.summarize(): String {
    if (this.isEmpty()) return "商品なし"
    return "${this.first()} 外${this.size - 1}点"
}


fun main() {
    // 動作確認用
    val price = 12500
    println(price.toYenFormat())

    val items = listOf("Kotlin入門書", "Spring Boot解説本", "Javaリファレンス")
    println(items.summarize())

    val emptyItems = emptyList<String>()
    println(emptyItems.summarize())
}