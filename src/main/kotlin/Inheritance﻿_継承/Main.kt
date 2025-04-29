package org.example.`Inheritance﻿_継承`

// 問題1: 継承可能なクラスと継承したクラスを作成してください。
// - Animal クラスを定義し、open 修飾子を付けてください。
// - Animal クラスには open なメソッド speak() を定義し、「Animal is speaking」と出力するようにしてください。
// - Dog クラスを Animal クラスから継承し、speak() メソッドをオーバーライドして「Dog is barking」と出力してください。
// - main 関数内で Dog クラスのインスタンスを生成し、speak() を呼び出してください。

open class Animal {
    open fun speak() {
        println("Animal is speaking")
    }
}

class Dog : Animal() {
    override fun speak() {
        println("Dog is barking")
    }
}

// 問題2: プロパティのオーバーライドについて学びましょう。
// - open class Shape を作成し、open val vertexCount: Int = 0 を定義してください。
// - class Triangle を Shape から継承し、vertexCount を 3 でオーバーライドしてください。
// - class Square を Shape から継承し、vertexCount を 4 でオーバーライドしてください。
// - main 関数で Triangle と Square のインスタンスを生成し、それぞれの vertexCount を出力してください。

open class Shape {
    open val vertexCount: Int = 0
}

class Triangle : Shape() {
    override val vertexCount: Int = 3
}

class Square : Shape() {
    override val vertexCount: Int = 4
}

// 問題3: スーパークラスのメソッドを呼び出してみましょう。
// - open class Writer を定義し、open fun write() を作成し「Writing...」と出力してください。
// - class Author を Writer から継承し、write() をオーバーライドして、最初にスーパークラスの write() を呼び出し、次に「Author is writing a novel」と出力してください。
// - main 関数で Author のインスタンスを生成し、write() を呼び出してください。

open class Writer {
    open fun write() {
        println("Writing...")
    }
}

class Author : Writer() {
    override fun write() {
        super.write()
        println("Author is writing a novel")
    }
}

// 問題4: 二重継承によるオーバーライドの競合を解決しましょう。
// - open class A を定義し、open fun show() を定義して「A is showing」と出力してください。
// - interface B を定義し、fun show() を定義して「B is showing」と出力してください。
// - class C を A から継承し B を実装してください。
// - C クラスで show() をオーバーライドし、super<A>.show() および super<B>.show() を順に呼び出すようにしてください。
// - main 関数で C のインスタンスを生成し、show() を呼び出してください。

open class A {
    open fun show() {
        println("A is showing")
    }
}

// クラスは二重継承することはできない
interface B {
    open fun show() {
        println("B is showing")
    }
}

class C : A(), B {
    override fun show() {
        super<A>.show()
        super<B>.show()
    }
}

fun main() {
    // 問題1
    Dog().speak()

    // 問題2
    println(Triangle().vertexCount)
    println(Square().vertexCount)

    // 問題3
    println(Author().write())

    // 問題4
    C().show()
}