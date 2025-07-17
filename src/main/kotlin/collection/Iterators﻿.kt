package org.example.collection

/**
 * 公式サイトのURL
 * https://kotlinlang.org/docs/iterators.html
 */

/*
問題: KotlinのイテレーターとMutableListIteratorの基本的な使い方を理解し、
以下の要件を満たすようにコードを完成させてください。

以下のコードスニペットには、特定の条件で動作しない部分や、期待される出力にならない部分があります。
各コメントの指示に従い、Kotlinのイテレーターを適切に使用して、
期待される出力を得るようにしてください。

--- 期待される出力 ---
元のリスト: [Alpha, Beta, Gamma, Delta, Epsilon]
順方向イテレーション: Alpha Beta Gamma Delta Epsilon
逆方向イテレーション（値とインデックス）:
Index: 4, value: Epsilon
Index: 3, value: Delta
Index: 2, value: Gamma
Index: 1, value: Beta
Index: 0, value: Alpha
修正後リスト: [Apple, Banana, Orange, Grape, Kiwi]
---

制約:
- 既存の 'words' リストは変更しないでください。
- 'TODO("ここにコードを記述")' の部分のみを修正・追記してください。
- 各行のコメントを参考にしてください。
- `for`ループや`forEach`は使用せず、明示的にイテレーターオブジェクトを操作してください。
*/

fun main() {
    val words = mutableListOf("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
    println("元のリスト: $words")

    // TODO 1: 'words' リストのイテレーターを取得し、順方向に全ての要素をスペース区切りで出力してください。
    //         出力例: 順方向イテレーション: Alpha Beta Gamma Delta Epsilon
    print("順方向イテレーション: ")
    val iterator1 = words.iterator()
    while (iterator1.hasNext()) {
        print("${iterator1.next()} ")
    }
    println()

    // TODO 2: 'words' リストの ListIterator を取得し、まず順方向に最後まで進めた後、
    //         逆方向に全ての要素とそのインデックスを出力してください。
    //         出力例:
    //         Index: 4, value: Epsilon
    //         Index: 3, value: Delta
    //         ...
    println("逆方向イテレーション（値とインデックス）:")
    val listIterator = words.listIterator()
    while (listIterator.hasNext()){
       listIterator.next()
    }
    while (listIterator.hasPrevious()){
        print("Index: ${listIterator.previousIndex()}")
        println(", value: ${listIterator.previous()}")
    }


    // TODO 3: 'words' リストの MutableListIterator を取得し、以下の操作を行ってください。
    //         - 最初の要素に進んだ後、現在の要素を "Apple" に置き換える
    //         - 次の要素に進んだ後、現在の要素を "Banana" に置き換える
    //         - さらに次の要素に進んだ後、"Orange" を挿入する
    //         - 残りの要素を進みながら、それぞれを "Grape" と "Kiwi" に置き換える
    //         出力例: 修正後リスト: [Apple, Banana, Orange, Grape, Kiwi]
    //         ヒント: add() と set() メソッドを使用してください。
    //               ループを一度で完了させる必要はありません。必要なだけ next() を呼び出してください。
    val iterator = words.listIterator()
    iterator.next()
    iterator.set("Apple")
    iterator.next()
    iterator.set("Banana")
    iterator.next()
    iterator.add("Orange")
    iterator.next()
    iterator.set("Grape")
    iterator.next()
    iterator.set("Kiwi")
    println("修正後リスト: $words")
}