package ru.ksilin.study.hackerrank.algorithms.warmup

fun main(args: Array<String>) {
    val arr = readLine()!!.split(" ").map{ it.trim().toLong() }.toLongArray()
    arr.sort()

    val minSum = arr.take(4).sum()
    val maxSum = arr.takeLast(4).sum()
    println("$minSum $maxSum")
}
