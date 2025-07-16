package org.example.collection

/*
問題: Kotlinのコレクション操作関数（filter, map, associateWith など）の基本的な使い方を理解し、
以下の要件を満たすようにコードを完成させてください。

以下のコードスニペットには、特定の条件で動作しない部分や、期待される出力にならない部分があります。
各コメントの指示に従い、Kotlinのコレクション操作関数を適切に使用して、
期待される出力を得るようにしてください。

--- 期待される出力 ---
元のリスト: [Apple, Banana, Cherry, Date, Elderberry, Fig]
長さが5より大きいフルーツ: [Banana, Cherry, Date, Elderberry]
各フルーツの長さを抽出したリスト: [5, 6, 6, 4, 10, 3]
フルーツとその長さのマップ: {Apple=5, Banana=6, Cherry=6, Date=4, Elderberry=10, Fig=3}
---

制約:
- 既存の 'fruits' リストは変更しないでください。
- 'TODO("ここにコードを記述")' の部分のみを修正・追記してください。
- 各行のコメントを参考にしてください。
- コレクションの要素の追加や削除ではなく、既存のコレクション操作関数（filter, map, associateWith など）を
  使用して新しいコレクションを生成してください。
*/

fun main() {
    val fruits = listOf("Apple", "Banana", "Cherry", "Date", "Elderberry", "Fig")
    println("元のリスト: $fruits")

    // TODO: fruits リストから、文字列の長さが5より大きいフルーツだけを抽出して新しいリストを作成し、出力してください。
    //       出力例: 長さが5より大きいフルーツ: [Banana, Cherry, Date, Elderberry]
    val longFruits = fruits.filter{ it.length > 5}
    println("長さが5より大きいフルーツ: $longFruits")

    // TODO: fruits リストの各フルーツについて、その文字列の長さを抽出し、それらの長さのリストを作成して出力してください。
    //       出力例: 各フルーツの長さを抽出したリスト: [5, 6, 6, 4, 10, 3]
    val fruitLengths = fruits.map { it.length }
    println("各フルーツの長さを抽出したリスト: $fruitLengths")

    // TODO: fruits リストを使って、フルーツ名をキー、その文字列の長さを値とするマップを作成して出力してください。
    //       出力例: フルーツとその長さのマップ: {Apple=5, Banana=6, Cherry=6, Date=4, Elderberry=10, Fig=3}
    val fruitLengthMap = fruits.associateWith { it.length }
    println("フルーツとその長さのマップ: $fruitLengthMap")
}