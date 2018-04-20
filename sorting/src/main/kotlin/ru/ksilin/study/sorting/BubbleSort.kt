package ru.ksilin.study.sorting

import java.util.Arrays

fun sort(arrToSort: IntArray) {
    if (arrToSort.size > 1) {
        var buff: Int
        for (j in arrToSort.indices) {
            var isSorted = true
            for (i in 0 until arrToSort.size-1) {
                if (arrToSort[i] > arrToSort[i + 1]) {
                    isSorted = false
                    buff = arrToSort[i]
                    arrToSort[i] = arrToSort[i + 1]
                    arrToSort[i + 1] = buff
                }
            }

            if (isSorted) {
                println("Preliminary sorted")
                break
            }
        }
    }
}

fun bubbleSort(arr: IntArray) {
    if (arr.isEmpty()) {
        return
    }

    for (i in arr.size downTo 0) {
        for (j in 0 until i-1) {
            if (arr[j] > arr[j + 1]) {
                val buf = arr[j + 1]
                arr[j + 1] = arr[j]
                arr[j] = buf
            }
        }
    }
}

fun main(args: Array<String>) {
    val arrToSort = Utils.getRandomIntArray(10)!!
    val clone = arrToSort.clone()
    println(Arrays.toString(arrToSort))
    sort(arrToSort)
    bubbleSort(clone)
    println(Arrays.toString(arrToSort))

    println("Check sorted array: " + Utils.checkSort(arrToSort))
    println("Are equal result in different methods = ${arrToSort.contentEquals(clone)}")
}