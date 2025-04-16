package org.example.`class`

import kotlin.random.Random

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

    val empGen = RandomEmployeeGenerator(10, 30)
    println(empGen.generateEmployee())
    println(empGen.generateEmployee())
    println(empGen.generateEmployee())
    empGen.minSalary = 50
    empGen.maxSalary = 100
    println(empGen.generateEmployee())
}

class RandomEmployeeGenerator(var maxSalary: Int, var minSalary: Int){
    private val names = listOf("John", "Mary", "Ann", "Paul", "Jack", "Elizabeth")
    fun generateEmployee() =
        Employee(names.random(),
            Random.nextInt(from = minSalary, until = maxSalary))
}

data class Employee(val name: String, var salary: Int)

data class Person(
    val name: Name,
    val address: Address,
    val ownsAPet: Boolean = true
)

data class Name(val lastName: String, val firstName: String)

data class Address(val address: String, val city: City)

data class City(val name: String, val key: String)