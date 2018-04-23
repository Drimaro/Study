package ru.ksilin.study.hackerrank.algorithms.warmup

import java.time.format.DateTimeFormatter

fun main(args: Array<String>) {
    val line = readLine()!!

    val time = DateTimeFormatter.ofPattern("hh:mm:ssa").parse(line)

    println(DateTimeFormatter.ISO_LOCAL_TIME.format(time))
}
