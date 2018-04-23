package ru.ksilin.study.hackerrank.algorithms.warmup

fun main(args: Array<String>) {
    readLine()

//    val countedMap = readLine()!!.split(" ").map{ it.trim().toInt() }.groupingBy { it }.eachCount()
    val sortedList = readLine()!!.split(" ").map{ it.trim().toInt() }.sorted()

    val amount = sortedList.takeLastWhile { sortedList.last() == it}.count()
    println(amount)
}
