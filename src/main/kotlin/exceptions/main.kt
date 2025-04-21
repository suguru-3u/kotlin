package org.example.exceptions

fun main() {
    registerUser(username = "Yuki", age = 20)
}

/**
 * 前提条件関数を使った例外のスロー
 *
 * Kotlinでは、前提条件関数（precondition functions） を使って、条件を満たさない場合に自動的に例外をスローする方法も提供されています。
 * 関数	使用用途	スローされる例外
 * require()    ユーザー入力の妥当性を検証	    IllegalArgumentException
 * check()	    オブジェクトや変数の状態を検証	IllegalStateException
 * error()	    不正な状態・発生すべきでない条件	IllegalStateException
 */


fun registerUser(username: String?, age: Int) {
    require(username != null) { "username は null ではないこと。" }
    check(username.isNotBlank()) { "username は空文字列ではないこと。" }
    check(age >= 0) { "age は 0歳以上であること。" }
    if (age < 13) error("age が13未満の場合、利用できません")

    println("ユーザー登録成功: 名前=$username, 年齢=$age")
}