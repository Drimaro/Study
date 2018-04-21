package ru.ksilin.study.hackerrank.warmup

import java.util.*

fun aVeryBigSum(ar: LongArray): Long {
    return ar.sum()
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    // skip size
    scan.nextLine()

    val ar = scan.nextLine().split(" ").map{ it.trim().toLong() }.toLongArray()

    val result = aVeryBigSum(ar)

    println(result)
}
