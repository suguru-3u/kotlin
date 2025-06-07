package org.example.`Interfaces_Inheritance﻿_クラス継承`

/**
 * 公式サイトの情報
 * https://kotlinlang.org/docs/interfaces.html#resolving-overriding-conflicts
 */

// 継承にプロパティの設定

interface MyInterface {
    val prop: Int // 抽象プロパティを設定することができる

    val propertyWithImplementation: String
        get() = "foo"

    fun foo() {
        print(prop)
    }
}

class Child : MyInterface {
    override val prop: Int = 29
}


// interfaceの多重継承

interface Named {
    val name: String
}

interface Person : Named {
    val firstName: String
    val lastName: String

    override val name: String get() = "$firstName $lastName"
}

data class Employee(
    // 'name' の実装は不要
    override val firstName: String,
    override val lastName: String,
    val position: String
) : Person


// 複数のinterfaceの継承

interface A {
    fun foo() { println("A") }
    fun bar()
}

interface B {
    fun foo() { println("B") }
    fun bar() { println("bar") }
}

class D : A, B {
    override fun foo() {
        super<A>.foo()
        super<B>.foo()
    }

    override fun bar() {
        super<B>.bar()
    }
}


fun main(){
    val child = Child()
    child.foo()
    println(child.propertyWithImplementation)

    val employee = Employee(
        firstName = "a",
        lastName = "b",
        position = "c"
    )
    println(employee.name)

    val d = D()
    d.foo()
    d.bar()
}



