package ru.ksilin.study.sorting

fun selectionSort(arr: IntArray) {
    if (arr.isEmpty())
        return

    for (i in arr.indices) {
        var minIdx = i
        for (j in i+1..arr.lastIndex) {
            if (arr[minIdx] > arr[j]) {
                minIdx = j
            }
        }

        val tmp = arr[minIdx]
        arr[minIdx] = arr[i]
        arr[i] = tmp
    }
}

fun main() {
    val arrToSort = Utils.getRandomIntArray(10)
    println(arrToSort.contentToString())
    selectionSort(arrToSort)
    println(arrToSort.contentToString())

    println("Check sorted array: " + Utils.checkSort(arrToSort))
}