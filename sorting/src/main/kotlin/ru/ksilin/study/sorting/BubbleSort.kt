package ru.ksilin.study.sorting

import ru.ksilin.study.sorting.Utils.swap

fun bubbleSort(arr: IntArray) {
    if (arr.isEmpty()) {
        return
    }

    for (i in arr.lastIndex downTo 0) {
        for (j in 0 until i) {
            if (arr[j] > arr[j+1]) {
                swap(arr, j, j+1)
            }
        }
    }
}

fun bubbleSortTwoWay(arr: IntArray) {
    var rightIdx = arr.lastIndex
    var leftIdx = 0
    while (rightIdx > leftIdx) {
        for (i in leftIdx until rightIdx) {
            if (arr[i] > arr[i+1])
                swap(arr, i, i+1)
        }
        --rightIdx
        for (i in rightIdx downTo leftIdx+1) {
            if (arr[i] < arr[i-1])
                swap(arr, i, i-1)
        }
        ++leftIdx
    }
}

fun oddEvenSort(arr: IntArray) {
    var isSorted = false
    while (!isSorted) {
        isSorted = true
        for (i in 0 until arr.lastIndex step 2) {
            if (arr[i] > arr[i+1]) {
                swap(arr, i, i+1)
                isSorted = false
            }
        }

        for (i in 1 until arr.lastIndex step 2) {
            if (arr[i] > arr[i+1]) {
                swap(arr, i, i+1)
                isSorted = false
            }
        }
    }
}

fun main() {
//    checkBubbleSort()
//    checkTwoWayBubbleSort()
    checkOddEvenSort()
}

fun runSortFunction(sortFunction: (arr: IntArray) -> Unit) {
    val arrToSort = Utils.getRandomIntArray(10)
    val clone = arrToSort.clone()
    println(arrToSort.contentToString())
    arrToSort.sort()
    sortFunction(clone)
    println(arrToSort.contentToString())

    println("Check sorted array: " + Utils.checkSort(arrToSort))
    println("Are equal result in different methods = ${arrToSort.contentEquals(clone)}")
}

fun checkTwoWayBubbleSort() {
    runSortFunction { bubbleSortTwoWay(it) }
}

fun checkBubbleSort() {
    runSortFunction { bubbleSort(it) }
}

fun checkOddEvenSort() {
    runSortFunction { oddEvenSort(it) }
}