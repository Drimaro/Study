package ru.ksilin.study.hackerrank.algorithms.implementation

fun countApplesAndOranges(s: Int, t: Int, a: Int, b: Int, apples: Array<Int>, oranges: Array<Int>) {
    val aS = s - a
    val aE = t - a
    println(apples.filter { it in aS..aE }.count())

    val oS = s - b
    val oE = t - b
    println(oranges.filter { it in oS..oE }.count())
}

fun main(args: Array<String>) {

    val st = readLine()!!.split(" ")
    val s = st[0].trim().toInt()
    val t = st[1].trim().toInt()

    val ab = readLine()!!.split(" ")
    val a = ab[0].trim().toInt()
    val b = ab[1].trim().toInt()

    readLine()

    val apple = readLine()!!.split(" ").map{ it.trim().toInt() }.toTypedArray()
    val orange = readLine()!!.split(" ").map{ it.trim().toInt() }.toTypedArray()

    countApplesAndOranges(s, t, a, b, apple, orange)
}
