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

fun main() {
//    insertionSortCheck()
    val dupsArr = intArrayOf(1, 1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 7, 7, 7, 7, 7)
    val noDupsArr = noDups(dupsArr)
    println("Array with duplicates ${dupsArr.contentToString()}")
    println("Array without duplicates ${noDupsArr.contentToString()}")
}

private fun insertionSortCheck() {
    val arrToSort = Utils.getRandomIntArray(10)
    println(arrToSort.contentToString())
    insertionSort(arrToSort)
    println(arrToSort.contentToString())

    println("Check sorted array: " + Utils.checkSort(arrToSort))
}