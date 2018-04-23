package ru.ksilin.study.hackerrank.algorithms.warmup

import java.util.*

fun staircase(n: Int) {
    val stack = Stack<Char>()
    for (i in 0 until n) {
        repeat(n, { if (i >= it) stack.push('#') else stack.push(' ') })
        while (!stack.isEmpty()) {
            print(stack.pop())
        }
        println()
    }
}

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    staircase(n)
}
