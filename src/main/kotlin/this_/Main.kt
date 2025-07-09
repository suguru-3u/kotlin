package org.example.this_

/**
 * 公式サイトのthisのURL
 * https://kotlinlang.org/docs/this-expressions.html
 */


/*
問題: Kotlinの 'this' キーワードの振る舞いを理解し、以下の要件を満たすようにコードを完成させてください。

以下のコードスニペットには、特定の条件で動作しない部分や、意図しない出力になる部分があります。
'this' の使い方を適切に修正・追記し、期待される出力を得るようにしてください。

--- 期待される出力 ---
Outer instance ID: 100
Inner instance ID: 200
Extension ID: 300
Local Lambda ID: 400
Outer from lambda: 100
---

制約:
- 既存の構造（クラス、関数、ラムダの定義）は変更しないでください。
- 'TODO("ここにコードを記述")' の部分のみを修正・追記してください。
- 各行のコメントを参考にしてください。

*/

class OuterClass(val id: Int) {
    inner class InnerClass(val id: Int) {
        fun printIds() {
            // InnerClassのインスタンスIDを出力する
            println("Inner instance ID: ${this.id}")

            // OuterClassのインスタンスIDを出力する
            println("Outer instance ID: ${this@OuterClass.id}")

            val myLambda = {
                val lambdaId = 400
                // myLambdaのスコープ内で利用可能なOuterClassのインスタンスIDを出力する
                // （ヒント: ラムダはレシーバーを持たないが、外側のスコープのthisにアクセス可能）
                println("Outer from lambda: ${this@OuterClass.id}")
                println("Local Lambda ID: ${lambdaId}")
            }
            myLambda()
        }
    }

    // Int型に対する拡張関数
    fun printExtensionId() {
        // この拡張関数が適用されているIntの値（レシーバー）を出力する
        println("Extension ID: ${this}")
    }
}

fun main() {
    val outer = OuterClass(100)
    val inner = outer.InnerClass(200)

    inner.printIds()

    // 拡張関数を呼び出し、期待される出力が得られるように引数を渡す
    val method = OuterClass(300)
    method.printExtensionId()
}