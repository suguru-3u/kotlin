package org.example.collection

/**
 * 問題1: 閉じられたレンジの作成と確認
 *
 * 1から5までの数字を含む閉じられたレンジを作成し、
 * そのレンジに5が含まれているかをチェックするコードを記述してください。
 * 結果をprintln()で出力してください。
 */
fun problem1() {
    // ここにコードを記述
    println(5 in 1..5)
}

/**
 * 問題2: オープンエンドレンジの作成と確認
 *
 * 1から5までの数字（ただし5は含まない）を表すオープンエンドレンジを作成し、
 * そのレンジに5が含まれているかをチェックするコードを記述してください。
 * 結果をprintln()で出力してください。
 */
fun problem2() {
    // ここにコードを記述
    println(5 in 1..<5)
}

/**
 * 問題3: forループとレンジによる数値の出力
 *
 * 1から3までの数字をforループと閉じられたレンジを使って、
 * 1行に続けて出力するコードを記述してください。
 * 例: 123
 */
fun problem3() {
    // ここにコードを記述
    for (i in 1 .. 3){
        print(i)
    }
}

/**
 * 問題4: downToを使った逆順出力
 *
 * 5から1までの数字をdownTo関数とforループを使って、
 * 1行に続けて逆順に出力するコードを記述してください。
 * 例: 54321
 */
fun problem4() {
    // ここにコードを記述
    for(i in 5 downTo 1){
        print(i)
    }
}

/**
 * 問題5: stepを使ったカスタムステップ出力
 *
 * 0から10までの偶数（0, 2, 4, 6, 8, 10）を、
 * step関数と閉じられたレンジを使って、1行に続けて出力するコードを記述してください。
 * 例: 0246810
 */
fun problem5() {
    // ここにコードを記述
    for (i in 1 .. 10 step 2){
        print(i)
    }
}

/**
 * 問題6: filterを使った偶数の抽出
 *
 * 1から10までのレンジから、偶数のみを抽出し、
 * その結果をprintln()で出力してください。
 * 例: [2, 4, 6, 8, 10]
 */
fun problem6() {
    // ここにコードを記述
    println((1..10).filter { it % 2 == 0 })
}

fun main() {
    println("--- 問題1 ---")
    problem1()
    println("\n--- 問題2 ---")
    problem2()
    println("\n--- 問題3 ---")
    problem3()
    println("\n--- 問題4 ---")
    problem4()
    println("\n--- 問題5 ---")
    problem5()
    println("\n--- 問題6 ---")
    problem6()
}