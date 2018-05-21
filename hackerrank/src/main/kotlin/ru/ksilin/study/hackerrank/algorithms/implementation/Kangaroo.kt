package ru.ksilin.study.hackerrank.algorithms.implementation

fun main(args: Array<String>) {
    val x1V1X2V2 = readLine()!!.split(" ")
    val x1 = x1V1X2V2[0].trim().toInt()
    val v1 = x1V1X2V2[1].trim().toInt()
    val x2 = x1V1X2V2[2].trim().toInt()
    val v2 = x1V1X2V2[3].trim().toInt()

    if(v2 >= v1) println("NO")
    else println(if((x2 - x1) % (v1 - v2) == 0) "YES" else "NO")
}
