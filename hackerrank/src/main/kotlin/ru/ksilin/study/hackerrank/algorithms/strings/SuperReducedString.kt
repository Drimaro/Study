package ru.ksilin.study.hackerrank.algorithms.strings

fun main(args: Array<String>) {
    val toReduce = readLine()!!
    var resultStr = toReduce
    while(true) {
        val (reduced, result) = reduce(resultStr)
        resultStr = result
        if (!reduced || resultStr.isBlank()) break
    }
    println(if (resultStr.isBlank()) "Empty String" else resultStr)
}

fun reduce(str: String) : ReduceResult {
    var reduced = false
    if (str.length < 2) return ReduceResult(reduced, str)

    val sb = StringBuilder()
    val toCharArray = str.toCharArray()
    var i = 0
    do {
        val first = toCharArray[i]
        val second = toCharArray[i+1]
        if (first == second) {
            i += 2
            reduced = true
        } else {
            i++
            sb.append(first)
        }
    } while (i < toCharArray.size-1)
    if (i < toCharArray.size) sb.append(toCharArray.last())
    return ReduceResult(reduced, sb.toString())
}

data class ReduceResult(val reduced: Boolean, val result: String)