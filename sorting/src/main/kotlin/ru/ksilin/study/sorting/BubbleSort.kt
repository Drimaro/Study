package ru.ksilin.study.sorting

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

fun swap(arr: IntArray, idx1: Int, idx2: Int) {
    val buf = arr[idx1]
    arr[idx1] = arr[idx2]
    arr[idx2] = buf
}

fun main() {
//    checkBubbleSort()
    checkTwoWayBubbleSort()
}

@Suppress("DuplicatedCode")
fun checkTwoWayBubbleSort() {
    val arrToSort = Utils.getRandomIntArray(10)
    val clone = arrToSort.clone()
    println(arrToSort.contentToString())
    arrToSort.sort()
    bubbleSortTwoWay(clone)
    println(arrToSort.contentToString())

    println("Check sorted array: " + Utils.checkSort(arrToSort))
    println("Are equal result in different methods = ${arrToSort.contentEquals(clone)}")
}

@Suppress("DuplicatedCode")
fun checkBubbleSort() {
    val arrToSort = Utils.getRandomIntArray(10)
    val clone = arrToSort.clone()
    println(arrToSort.contentToString())
    arrToSort.sort()
    bubbleSort(clone)
    println(arrToSort.contentToString())

    println("Check sorted array: " + Utils.checkSort(arrToSort))
    println("Are equal result in different methods = ${arrToSort.contentEquals(clone)}")
}