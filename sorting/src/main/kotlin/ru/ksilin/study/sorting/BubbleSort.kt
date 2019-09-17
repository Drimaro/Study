package ru.ksilin.study.sorting

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

    for (i in arr.lastIndex downTo 0) {
        for (j in 0 until i) {
            if (arr[j] > arr[j+1]) {
                val tmp = arr[j+1]
                arr[j+1] = arr[j]
                arr[j] = tmp
            }
        }
    }
}

fun main() {
    val arrToSort = Utils.getRandomIntArray(10)
    val clone = arrToSort.clone()
    println(arrToSort.contentToString())
    sort(arrToSort)
    bubbleSort(clone)
    println(arrToSort.contentToString())

    println("Check sorted array: " + Utils.checkSort(arrToSort))
    println("Are equal result in different methods = ${arrToSort.contentEquals(clone)}")
}