package ru.ksilin.study.hackerrank.algorithms.implementation

fun main(args: Array<String>) {
    val x1V1X2V2 = readLine()!!.split(" ")
    var x1 = x1V1X2V2[0].trim().toInt()
    val v1 = x1V1X2V2[1].trim().toInt()
    var x2 = x1V1X2V2[2].trim().toInt()
    val v2 = x1V1X2V2[3].trim().toInt()

    var hasCommon = false
    while (!(hasCommon || x1 > x2 && v1 > v2 || x2 > x1 && v2 > v1 || x1 != x2 && v1 == v2)) {
        x1 += v1
        x2 += v2
        if (x1 == x2) hasCommon = true
    }

    if (hasCommon) println("YES") else println("NO")
}
