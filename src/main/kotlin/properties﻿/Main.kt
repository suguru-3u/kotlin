package org.example.`properties﻿`

import com.sun.jdi.Value

// 変数について

/**
 * 基本的に可変なvarとvalが存在する
 * クラスにも使用できる。
 */

// 可変
var sample1 = 1

// 不変
val sample2 = 2

// getterとsetterも何も記述しなくても使用することができる
class sample3(
    var sample1: Int,
    val sample2: Int
)

// Javaのstatic finalに相当するものがconstで使用することができる(使用するにはKotlinでルールがあるので確認すること)
// トップレベル定数
const val MIN_HP = 10
const val MAX_HP = 999

// companion object で使用
class OriginalMaxHitPoint(val value: Int) {
    companion object {
        const val MIN = 10
        const val MAX = 999
    }

    init {
        require(value in MIN..MAX) {
            "value must be between $MIN and $MAX"
        }
    }
}

// lateinit（プロパティの初期化を後回しにする）
// var（変更可能）で使う
class MyClass {
    lateinit var name: String

    fun init() {
        name = "Kotlin"
    }

    fun printName() {
        println(name)
    }
}

// lazy（プロパティの最初の使用時に初期化する）
// 主に（読み取り専用）で使う
val title: String by lazy {
    println("初期化中...")
    "Lazy Kotlin"
}

// 使い分けの目安
/**
 *
 * lateinit：
 *
 * プロパティに後から = 代入 したいとき
 * AndroidのViewやDI対象など、初期化が遅れる状況で使う
 *
 * lazy：
 *
 * 値が必要になるまで計算したくないとき（キャッシュしたいとき）
 * 計算コストが高い or 遅延初期化が合理的なとき
 */



