package ru.ksilin.study.hackerrank.algorithms.implementation

fun round(grade: Int) : Int {
    if (grade < 38) return grade

    val int = grade.div(5)
    val rem = grade.rem(5)
    if (rem >= 3 ) return (int + 1) * 5

    return grade
}

fun main(args: Array<String>) {

    val n = readLine()!!.trim().toInt()

    val grades = Array(n, { 0 })
    (0 until n).forEach( { grades[it] = readLine()!!.trim().toInt() } )
    grades.map { round(it) }.forEach { println(it) }
}
