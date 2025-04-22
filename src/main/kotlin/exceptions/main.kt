package org.example.exceptions

fun main() {
    registerUser(username = "Yuki", age = 20)

    try {
        authenticate("yes", true)
    } catch (ex: Exception) {
        when (ex) {
            is InvalidCredentialsException -> println("InvalidCredentialsException")
            is AccountLockedException -> println("AccountLockedException")
            is TokenExpiredException -> println("TokenExpiredException")
            else -> println("Exception")
        }
    }
}


sealed class AccountException(message: String, cause: Throwable? = null) :
    Exception(message)

class InvalidCredentialsException() :
    AccountException("Invalid credentials")

class AccountLockedException() :
    AccountException("Account has been locked")

class TokenExpiredException(
    message: String = "Token expired",
    cause: Throwable? = null
) : AccountException(message, cause)


fun authenticate(username: String, tokenValid: Boolean) {
    if (username == "admin") throw InvalidCredentialsException()
    if (username == "locked") throw AccountLockedException()
    if (!tokenValid) throw TokenExpiredException("Hello")

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