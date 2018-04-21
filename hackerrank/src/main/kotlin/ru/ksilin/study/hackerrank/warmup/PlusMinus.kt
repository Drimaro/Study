package ru.ksilin.study.hackerrank.warmup

import java.util.*

fun plusMinus(arr: Array<Int>) {
    val countedMap = arr.groupingBy { it.compareTo(0) }.eachCount()

    val positiveFraction = countedMap.get(1)?.div(arr.size.toDouble()) ?: .0
    val negativeFraction = countedMap.get(-1)?.div(arr.size.toDouble()) ?: .0
    val zeroFraction = countedMap.get(0)?.div(arr.size.toDouble()) ?: .0

    println("%.6f".format(positiveFraction))
    println("%.6f".format(negativeFraction))
    println("%.6f".format(zeroFraction))
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    scan.nextLine()

    val arr = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    plusMinus(arr)
}
