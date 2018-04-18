package ru.ksilin.study.sorting

import java.util.*

fun insertionSort(array: IntArray) {
    if (array.isEmpty())
        return

    for (i in 0 until array.size) {
    }
}

fun main(args: Array<String>) {
    val arrToSort = Utils.getRandomIntArray(10)!!
    println(Arrays.toString(arrToSort))
    insertionSort(arrToSort)
    println(Arrays.toString(arrToSort))

    println("Check sorted array: " + Utils.checkSort(arrToSort))
}