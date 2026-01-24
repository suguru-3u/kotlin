package org.example.Sequence

import java.io.File
import kotlin.system.measureTimeMillis

/**
 * Listを用いて中間処理を行うと全ての処理が終わるまで、次の処理を行わない。つまり中間処理毎にメモリを圧迫してしまう。
 * Sequenceは、中間処理行い、次の処理があると次の処理に進む。中間結果を溜め込むことがないため、メモリを圧迫しない
 * /終端 操作を行わないとSequenceの操作は行なわれない、あくまでSequenceはこうゆう操作を行うよって予約をしているに過ぎない
 */

fun main(){
    // Iterableの場合
    //    val result = bigList
    //        .map { it.heavyFunction() } // 全件(100万回)実行される
    //        .filter { it.isValid }      // 全件実行される
    //        .take(3)                    // 最後に3つ取る
    //
    //// Sequenceの場合
    //    val result = bigList.asSequence()
    //        .map { it.heavyFunction() }
    //        .filter { it.isValid }
    //        .take(3)                    // 3つ見つかった時点で処理が止まる！
    //        .toList()

    // ダミーデータを作成 (0 〜 5000)
    val bigList = (1..5000).toList()

    println("データ件数: ${bigList.size}件\n")

    // --- Iterable (List) の場合 ---
    val timeIterable = measureTimeMillis {
        val result = bigList
            .map {
                // 重い処理をシミュレート
                Thread.sleep(1)
                it * 2
            }
            .filter {
                it % 3 == 0
            }
            .take(10) // 最初の10個だけ欲しい
            .toList()

        println("Iterableの結果: $result")
    }
    println("Iterableの処理時間: ${timeIterable}ms")

    println("-------------------------")

    // --- Sequence の場合 ---
    val timeSequence1 = measureTimeMillis {
        val result = bigList.asSequence()
            .map {
                Thread.sleep(1)
                println("Sequenceのmap実行")
                it * 2
            }
            .filter {
                println("Sequenceのfilter実行")
                it % 3 == 0
            }
            .take(10) // 最初の10個だけ欲しい
//            .toList() // ここで初めて計算が始まる

        println("Sequenceの結果: $result")
    }
    println("Sequenceの処理時間: ${timeSequence1}ms")

    val timeSequence2 = measureTimeMillis {
        val result = generateSequence(){
        }
    }
}

// 強大なファイルを取得してパフォーマンスを意識する場合、useLinesが使えそう
fun processHugeFile(fileName: String) {
    val file = File(fileName)

    // useLines はファイルを自動で開き、処理が終わると自動で閉じてくれる
    val errorCount =  file.useLines { lines: Sequence<String> ->
        // ここで受け取る 'lines' は Sequence なので、全行をメモリに読み込まない
        lines
            .filter { line -> line.contains("ERROR") } // 1. エラー行だけに絞る
            .map { line -> line.uppercase() }         // 2. 大文字に加工する
            .toList()                                  // 3. 終端操作：件数を数える
    }
    println("エラー件数: ${errorCount}件")
}

