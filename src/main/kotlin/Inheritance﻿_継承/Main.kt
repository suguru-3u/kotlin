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

// 問題5: val と var のオーバーライドについて学びましょう。
// - open class Book を定義し、open val title: String = "Unknown" を定義してください。
// - class Novel を Book から継承し、title を var にして "Mystery Novel" にオーバーライドしてください。
// - main 関数で Novel のインスタンスを作成し、title を出力後、別のタイトルに変更して再度出力してください。

open class Book {
    open val title: String = "Unknown"
}

class Novel : Book() {
    override var title: String = "Mystery Novel"
}


// 問題6: プライマリコンストラクタとスーパークラスの初期化の順序を理解しましょう。
// - open class Base を定義し、name: String を受け取るプライマリコンストラクタを作成してください。
// - Base の init ブロック内で「Base initialized with name: $name」を出力してください。
// - open val description: String を name.length に基づいて初期化し、その初期化もログとして出力してください。
// - class Derived を Base から継承し、lastName: String を追加で受け取るようにしてください。
// - Derived の init ブロックと description の初期化でもログを出力してください。
// - main 関数で Derived のインスタンスを作成し、初期化の順序を確認してください。

open class Base(name: String) {
    open val description: String = name.length.toString().also {
        println("Base description initialized with length: $it")
    }

    init {
        println("Base initialized with name: $name")
    }
}

class Derived(name: String, lastName: String) : Base(name) {
    override val description: String = (name + lastName).length.toString().also {
        println("Derived description initialized with length: $it")
    }

    init {
        println("Derived initialized with name: $name and lastName: $lastName")
    }
}

// 問題7: inner class から外側のスーパークラスのメソッドにアクセスしてみましょう。
// - open class OuterBase を作成し、open fun greet() で「Hello from OuterBase」と出力してください。
// - class Outer を OuterBase から継承し、greet() をオーバーライドして「Hello from Outer」と出力してください。
// - Outer に inner class Inner を定義し、その中に fun callSuperGreet() を定義してください。
// - callSuperGreet() では super@Outer.greet() を使って OuterBase の greet() を呼び出してください。
// - main 関数で Outer.Inner のインスタンスを作成し、callSuperGreet() を呼び出してください。

open class OuterBase {
    open fun greet() {
        println("Hello from OuterBase")
    }
}

class Outer : OuterBase() {
    override fun greet() {
        println("Hello from Outer")
    }

    inner class Inner {
        fun callSuperGreet() {
            super@Outer.greet()
        }
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

    // 問題5
    println(Novel().title)
    Novel().title = "Change Title"
    println(Novel().title)
}