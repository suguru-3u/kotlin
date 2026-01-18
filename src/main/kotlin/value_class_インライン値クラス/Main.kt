package org.example.value_class_インライン値クラス

/**
 * 練習問題：型安全な注文処理システム
 * あなたは、注文処理システムの開発を任されました。 このシステムでは、「ユーザーID」 と 「商品ID」 をどちらも Long 型で扱っていましたが、引数の順番を間違えて渡してしまうバグが多発しています。
 *
 * これを value class を使って修正してください。
 *
 * 仕様1：value class の定義
 * 以下の2つの value class を作成してください。 どちらも Long 型の値を1つ保持します。
 *
 * UserId
 *
 * ProductId ※ value class を定義する際は、適切なアノテーションが必要です。
 *
 * 仕様2：拡張プロパティ/関数の実装
 * UserId クラスに、以下のプロパティまたは関数を追加してください。
 *
 * isValid: 保持している値が 0 より大きい場合に true を返すプロパティ。
 *
 * 仕様3：処理関数の実装
 * 以下の関数を実装してください（中身は println でOKです）。
 *
 * 関数名: processOrder
 *
 * 引数: userId: UserId, productId: ProductId
 *
 * 内容: 「User [IDの値] が Product [IDの値] を注文しました」と表示する。
 */


@JvmInline
value class UserId(val value: Long)

@JvmInline
value class ProductId(val value: Long)

val UserId.isValid: Boolean
    get() = this.value > 0

fun processOrder(userId: UserId, productId: ProductId) {
    println("User ${userId.value} が Product ${productId.value} を注文しました")
}

fun main() {
    // 3. 以下のコードが正しく動くようにしてください
    val myUser = UserId(101L)
    val myProduct = ProductId(5005L)

    if (myUser.isValid) {
        processOrder(myUser, myProduct)
    }
}


