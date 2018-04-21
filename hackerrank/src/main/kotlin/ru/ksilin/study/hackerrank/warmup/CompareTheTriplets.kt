package ru.ksilin.study.hackerrank.warmup

import java.util.*

fun solve(aScores: IntArray, bScores: IntArray): Array<Int> {
    val resultScore = Array(2, { 0 })
    for (i in 0 until aScores.size) {
        val pointsDiff = aScores[i] - bScores[i]
        when {
            pointsDiff > 0 -> resultScore[0] = ++resultScore[0]
            pointsDiff < 0 -> resultScore[1] = ++resultScore[1]
        }
    }
    return resultScore
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val aScores = scan.nextLine().split(" ").map { it.trim().toInt() }.toIntArray()

    val bScores = scan.nextLine().split(" ").map { it.trim().toInt() }.toIntArray()

    val result = solve(aScores, bScores)

    println(result.joinToString(" "))
}