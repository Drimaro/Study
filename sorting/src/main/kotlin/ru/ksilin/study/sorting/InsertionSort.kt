package ru.ksilin.study.sorting

import ru.ksilin.study.sorting.Utils.swap

fun insertionSort(arr: IntArray) {
    var comparisonCnt = 0
    var moveCnt = 0
    for (i in 1..arr.lastIndex) {
        val tmp = arr[i]
        var innerIdx = i
        while (innerIdx > 0) {
            ++comparisonCnt
            if (tmp > arr[innerIdx-1]) break
            ++moveCnt
            arr[innerIdx] = arr[innerIdx-1]
            innerIdx--
        }
        arr[innerIdx] = tmp
    }
    println("To sort array with size = ${arr.size} compared $comparisonCnt and moved $moveCnt elements.")
}

/**
 * remove duplicates from sorted array
 */
fun noDups(arr: IntArray): IntArray {
    var elemId = 0
    for (i in 1..arr.lastIndex) {
        if (arr[elemId] == arr[i]) {
            continue
        } else {
            arr[++elemId] = arr[i]
        }
    }
    return arr.copyOfRange(0, elemId+1)
}

fun insertionSortWithNoDups(arr: IntArray): IntArray {
    var dupsLastIdx = -1
    for (i in arr.indices) {
        val tmpElement = arr[i]
        var innerIdx = i
        innerLoop@ while (innerIdx > 0 && innerIdx > dupsLastIdx+1) {
            when {
                tmpElement == arr[innerIdx-1] -> {
                    for (j in innerIdx downTo dupsLastIdx+2) {
                        arr[j] = arr[j-1]
                    }
                    innerIdx = ++dupsLastIdx
                    break@innerLoop
                }
                tmpElement < arr[innerIdx-1] -> {
                    arr[innerIdx] = arr[innerIdx-1]
                    innerIdx--
                }
                else -> break@innerLoop
            }
        }
        arr[innerIdx] = tmpElement
    }
    return arr.copyOfRange(dupsLastIdx+1, arr.size)
}

fun main() {
//    insertionSortCheck()
//    noDupsCheck()
    insertionSortNoDupsCheck()
}

fun noDupsCheck() {
    val dupsArr = intArrayOf(1, 1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 7, 7, 7, 7, 7)
    val noDupsArr = noDups(dupsArr)
    println("Array with duplicates ${dupsArr.contentToString()}")
    println("Array without duplicates ${noDupsArr.contentToString()}")
}

fun insertionSortNoDupsCheck() {
    val dupsArr = intArrayOf(1, 1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 7, 7, 7, 7, 7)
    dupsArr.reverse()
    println(dupsArr.contentToString())
    val noDupsArr = insertionSortWithNoDups(dupsArr)
    println("Array with duplicates ${dupsArr.contentToString()}")
    println("Array without duplicates ${noDupsArr.contentToString()}")
}

fun insertionSortCheck() {
    val arrToSort = Utils.getRandomIntArray(100)
    println(arrToSort.contentToString())
    insertionSort(arrToSort)
    println(arrToSort.contentToString())
    println("Check sorted array: " + Utils.checkSort(arrToSort))
    println("Swapping several elements")
    swap(arrToSort, 35, 55)
    swap(arrToSort, 60, 6)
    println("Check sorted array: " + Utils.checkSort(arrToSort))
    insertionSort(arrToSort)
    println("Check sorted array: " + Utils.checkSort(arrToSort))
}