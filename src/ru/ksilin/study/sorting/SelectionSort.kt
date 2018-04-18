package ru.ksilin.study.sorting

import java.util.*

fun selectionSort(array: IntArray) {
    if (array.isEmpty())
        return

    for (i in 0 until array.size-1) {
        var min = i

        for (j in i+1 until array.size) {
            if (array[min] > array[j]) {
                min = j
            }
        }

        val buf = array[min]
        array[min] = array[i]
        array[i] = buf
    }
}

fun main(args: Array<String>) {
    val arrToSort = Utils.getRandomIntArray(10)!!
    println(Arrays.toString(arrToSort))
    selectionSort(arrToSort)
    println(Arrays.toString(arrToSort))

    println("Check sorted array: " + Utils.checkSort(arrToSort))
}