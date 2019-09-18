package ru.ksilin.study.sorting

import kotlin.random.Random

object Utils {

    fun getRandomIntArray(capacity: Int): IntArray {
        val result = IntArray(capacity)
        for (i in result.indices) {
            result[i] = Random.nextInt()
        }

        return result
    }

    fun checkSort(sortedArray: IntArray): Boolean {
        for (i in 0 until sortedArray.size - 1) {
            if (sortedArray[i] > sortedArray[i + 1]) {
                return false
            }
        }
        return true
    }

    fun swap(arr: IntArray, idx1: Int, idx2: Int) {
        val buf = arr[idx1]
        arr[idx1] = arr[idx2]
        arr[idx2] = buf
    }
}
