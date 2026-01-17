package org.example.`class`

import kotlin.random.Random

/**
 * 公式サイト
 * https://kotlinlang.org/docs/classes.html
 */

fun main() {
    val emp = Employee("Mary", 20)
    println(emp)
    emp.salary += 10
    println(emp)

    val person = Person(
        Name("John", "Smith"),
        Address("123 Fake Street", City("Springfield", "US")),
        ownsAPet = false
    )
    println(person)

    ShapeFactory.createShape("circle").draw()
}

// 以下の条件を満たすKotlinプログラムを作成してください。
//
// 1. 抽象クラス「Shape」を作成し、抽象関数「draw」を定義してください。
// 2. 「Rectangle」と「Circle」という2つのクラスをShapeから継承し、それぞれdraw関数をオーバーライドして、
//    "Drawing a rectangle"、"Drawing a circle" と出力するようにしてください。
// 3. Shapeクラスには、共通処理として「name」というプロパティを追加し、主コンストラクタで初期化できるようにしてください。
// 4. 「ShapeFactory」というクラスを定義し、その中に「createShape」という関数を用意してください。
//    引数として "rectangle" または "circle" を受け取り、対応するShapeインスタンスを返すようにしてください。
// 5. ShapeFactoryの「createShape」は、ShapeFactoryのcompanion object内に定義してください。
// 6. main関数を定義し、ShapeFactory.createShape("circle") のように呼び出して、戻ってきたインスタンスでdraw関数を呼び出してください。

// あなたのコードはこの下に書いてください。
abstract class Shape(val name: String) {
    abstract fun draw()
}

class Rectangle(name: String) : Shape(name) {
    override fun draw() {
        println("Drawing a rectangle")
    }
}

class Circle(name: String) : Shape(name) {
    override fun draw() {
        println("Drawing a circle")
    }
}

class ShapeFactory() {
    companion object {
        fun createShape(shapeClassName: String): Shape {
            return when (shapeClassName.lowercase()) {
                "rectangle" -> Rectangle(shapeClassName)
                else -> Circle(shapeClassName)
            }
        }
    }
}

// 以下の条件を満たすKotlinのクラスを作成してください。
//
// 1. クラス名は「Book」とする。
// 2. 「title（タイトル）」「author（著者）」「price（価格）」という3つのプロパティを持つこと。
// 　　- titleとauthorは読み取り専用（val）、priceは変更可能（var）にすること。
// 3. 主コンストラクタを使って、すべてのプロパティを初期化すること。
// 4. priceにはデフォルト値「0」を設定すること。
// 5. インスタンス生成時に初期化ブロックで「"Book titled '<タイトル>' by <著者> is created."」と出力すること。
// 6. Bookクラスには、副コンストラクタを1つ追加し、引数として「title」と「author」のみを受け取り、priceは初期値を使用すること。

// あなたのコードはこの下に書いてください。


class Oder(
    private val items: List<Item>
) {
    init {
        require( items.isEmpty()) {
            throw IllegalArgumentException("商品は1つ以上必要です")
        }
    }
    data class Item(val name: String, val price: Int)

    companion object{
         private const val tax: Double =  1.1
    }

    fun calculateTotalPrice(): Double {
        return items.sumOf { it.price } * tax
    }
}


class Book(val title: String, val author: String, var price: Int = 0) {
    init {
        println("Book titled '$title' by $author is created.")
    }

    constructor(title: String, author: String) : this(title, author, 500)
}

class RandomEmployeeGenerator(var maxSalary: Int, var minSalary: Int) {
    private val names =
        listOf("John", "Mary", "Ann", "Paul", "Jack", "Elizabeth")

    fun generateEmployee() =
        Employee(
            names.random(),
            Random.nextInt(from = minSalary, until = maxSalary)
        )
}

/**
 * データクラスには、equals(), .hashCode(), .toString(),.componentN(),.copy()のメソッドが自動で作成される
 * またdata classには不変なデータを保持することが期待されているため、valを用いて不変にする必要がある。
 *
 */
data class Employee(val name: String, var salary: Int)

data class Person(
    val name: Name,
    val address: Address,
    val ownsAPet: Boolean = true
)

data class Name(val lastName: String, val firstName: String)

data class Address(val address: String, val city: City)

data class City(val name: String, val key: String)