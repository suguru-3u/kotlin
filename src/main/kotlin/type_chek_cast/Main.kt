package org.example.type_chek_cast

fun main() {
    printStringLength("Hello")    // -> 5
    printStringLength(42)         // -> Not a string

    describeInput(123)              // -> Int value: 123
    describeInput("Kotlin")         // -> String length: 6
    describeInput(listOf(1, 2, 3))  // -> List size: 3
    describeInput(3.14)             // -> Unknown type

    val d = Dog()
    callIfDog(d)           // -> Woof!
    callIfDog("Not a dog") // -> Not a dog

    val values = listOf(42, "Hello", 3.14, "Kotlin", true)

    for (v in values) {
        // ここで `as` 演算子を使って型キャストし、大文字に変換
        val result = v as? String
            println(result?.uppercase() ?: "Not a string")
    }

    val obj: Any = 123

    // `obj` を `String` 型にキャストして、大文字に変換しようとする
    val result = obj as? String // キャスト失敗時にエラーを回避する処理を追加
    println(result?.uppercase() ?: "Not a string")  // この行でエラーになる可能性あり

    val obj2: Any = "Hello"

    // `obj` を `String` または `Int` にキャストして適切な処理を行う
    if (obj2 is String) {
        // String 型の場合、文字列の長さを表示
        val length = obj2 as String
        println("String length: ${length.length}")
    } else if (obj2 is Int) {
        // Int 型の場合、その2倍を表示
        val number = obj2 as Int
        println("Double value: ${number * 2}")
    }
}

class Dog {
    fun bark() {
        println("Woof!")
    }
}

fun callIfDog(animal: Any) {
    if(animal is Dog){
        animal.bark()
    } else {
        println("Not a dog")
    }
}

fun describeInput(x: Any) {
    // ここを完成させなさい
    when (x) {
        is Int -> println("Int value: $x")
        is String -> println("String length: ${x.length}")
        is List<*> -> println("List size: ${x.size}")
        else -> println("Unknown type")
    }
}

fun printStringLength(value: Any) {
    val result = if (value is String) value.length else "Not a string"
    println(result)
}
