package ru.ksilin.study.hackerrank.algorithms.sorting

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()

    val toSort = (0 until n).map { readLine()!! }.toList()
    val sorted = toSort.sortedWith(compareBy({ it.length }, { it }))

    println(sorted.joinToString("\n"))
}
