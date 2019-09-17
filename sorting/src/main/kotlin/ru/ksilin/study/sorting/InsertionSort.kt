package ru.ksilin.study.sorting

fun insertionSort(arr: IntArray) {
    for (i in 1..arr.lastIndex) {
        val tmp = arr[i]
        var innerIdx = i
        while (innerIdx > 0 && tmp <= arr[innerIdx-1]) {
            arr[innerIdx] = arr[innerIdx-1]
            innerIdx--
        }
        arr[innerIdx] = tmp
    }
}

fun main() {
    val arrToSort = Utils.getRandomIntArray(10)
    println(arrToSort.contentToString())
    insertionSort(arrToSort)
    println(arrToSort.contentToString())

    println("Check sorted array: " + Utils.checkSort(arrToSort))
}