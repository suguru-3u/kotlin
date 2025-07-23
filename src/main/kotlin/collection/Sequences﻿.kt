package org.example.collection

/**
 * 公式サイトURL
 * https://kotlinlang.org/docs/sequences.html
 */


// 問題: シーケンスの遅延評価とパフォーマンス
//
// 以下の仕様を満たすKotlinコードを記述してください。
//
// 1. 1から始まる無限のシーケンスを生成してください。
//    このシーケンスの各要素は、前の要素に3を足した値とします。
//
// 2. この無限シーケンスから、50000より大きく、かつ7で割り切れる最初の10個の偶数を抽出してください。
//
// 3. 抽出された数値がどのような順番で処理されているかを理解するため、
//    シーケンスのフィルタリングとマッピングの各ステップで、現在処理している要素の値を
//    コンソールに出力する`println`文を挟んでください。
//    例: "Filter: [値]", "Map: [値]"
//
// 4. 最終的に得られた10個の偶数のリストをコンソールに出力してください。
//

fun main() {
    val oddNumbers = generateSequence(1) { it + 3 }
    val result =
        oddNumbers.filter { println("Filter: [$it]"); it > 50000 && it % 7 == 0 && it % 2 == 0 }
            .map { println("Map: [$it]"); it }
            .take(10)

    println("-------------------")
    result.forEach { println(it) }
}

