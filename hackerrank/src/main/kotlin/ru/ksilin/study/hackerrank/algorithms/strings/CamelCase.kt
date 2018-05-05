package ru.ksilin.study.hackerrank.algorithms.strings

fun main(args: Array<String>) {
    val stringToCount = readLine()!!
    println(stringToCount.toCharArray().filter { it.isUpperCase() }.count() + 1)
}