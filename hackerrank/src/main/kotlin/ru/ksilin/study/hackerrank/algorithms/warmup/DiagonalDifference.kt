package ru.ksilin.study.hackerrank.algorithms.warmup

import java.util.*
import kotlin.math.abs

fun diagonalDifference(a: Array<IntArray>): Int {
    var primaryDiagonalSum = 0
    var secondaryDiagonalSum = 0
    var secondaryIdx = a.size - 1
    for (line in 0 until a.size) {
        primaryDiagonalSum += a[line][line]
        secondaryDiagonalSum += a[secondaryIdx][line]
        secondaryIdx.dec()
    }
    return abs(primaryDiagonalSum - secondaryDiagonalSum)
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val size = scan.nextLine().trim().toInt()

    val a = Array(size, { IntArray(size, { 0 }) })

    for (aRowItr in 0 until size) {
        a[aRowItr] = scan.nextLine().split(" ").map{ it.trim().toInt() }.toIntArray()
    }

    val result = diagonalDifference(a)

    println(result)
}
