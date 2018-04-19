package ru.ksilin.study.sorting

import java.util.*

fun insertionSort(array: IntArray) {
    if (array.isEmpty())
        return

    for (i in 0 until array.size) {
        val value = array[i]
        var idx = i
        while (idx > 0 && value <= array[idx-1]) {
            array[idx] = array[idx - 1]
            idx--
        }
        array[idx] = value
    }
}

fun main(args: Array<String>) {
    val arrToSort = Utils.getRandomIntArray(10)!!
    println(Arrays.toString(arrToSort))
    insertionSort(arrToSort)
    println(Arrays.toString(arrToSort))

    println("Check sorted array: " + Utils.checkSort(arrToSort))
}