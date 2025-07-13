package org.example.Asynchronous

import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.*
import kotlin.coroutines.EmptyCoroutineContext

/**
 * 公式サイトのURL
 * https://kotlinlang.org/docs/async-programming.html
 *
 * 非同期処理の方法
 * スレッド
 * コールバック
 * Future、Promise、その他
 * Reactive Extensions
 * コルーチン
 *
 */

/*
問題: Kotlinコルーチンの基本的な使い方を理解し、以下の要件を満たすようにコードを完成させてください。

以下のプログラムは、非同期処理を模倣した suspend 関数 'fetchData()' と 'processData()' を含んでいます。
これらの関数を使って、'main' 関数内で以下の期待される出力を得るようにコルーチンを起動し、
適切に結果を処理してください。

--- 期待される出力 ---
メイン処理開始
データ取得中...
データ処理中...
非同期処理がすべて完了しました: データA を処理しました
メイン処理終了
---

制約:
- 既存の 'fetchData()' および 'processData()' 関数のシグネチャ（定義）は変更しないでください。
- 'main' 関数内でのみコードを記述・修正し、期待される出力を実現してください。
- 'kotlinx.coroutines' ライブラリの適切なコルーチンビルダー（例: launch, async, runBlocking など）を使用してください。
- 'delay()' 関数を使用して、非同期処理の待機をシミュレートしてください。

*/


// データを非同期で取得する関数（時間のかかる処理を模倣）
suspend fun fetchData(): String {
    println("データ取得中...")
    delay(1500) // 1.5秒待機
    return "データA"
}

// 取得したデータを非同期で処理する関数（時間のかかる処理を模倣）
suspend fun processData(data: String): String {
    println("データ処理中...")
    delay(1000) // 1秒待機
    return "$data を処理しました"
}

fun main() {
    println("メイン処理開始")

    // runBlocking は、メインスレッドをブロックしてコルーチンの完了を待つ
    // テストやシンプルなCLIアプリケーションでよく使われる
    runBlocking {
        // fetchData() は suspend 関数なので、コルーチンスコープ内で直接呼び出せる
        val fetchedData = fetchData()

        // fetchedData の結果を使って processData() を呼び出す
        val processedResult = processData(fetchedData)

        // 最終結果を出力
        println("非同期処理がすべて完了しました: $processedResult")
    }

    println("メイン処理終了")
}

