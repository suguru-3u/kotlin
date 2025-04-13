package org.example.control_flow

fun main() {
    val trueNum = 1
    val falseNum = 2
    val check = true

    // 通常のif文
    if (check) {
        println(trueNum)
    } else {
        println(falseNum)
    }

    // 省略したif分
    println(if(check) trueNum else falseNum)
}