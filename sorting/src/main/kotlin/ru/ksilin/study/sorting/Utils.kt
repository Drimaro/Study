package ru.ksilin.study.sorting

import java.util.Random

object Utils {

    fun getRandomIntArray(capacity: Int): IntArray {
        val result = IntArray(capacity)
        val rand = Random()
        for (i in result.indices) {
            result[i] = rand.nextInt()
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
}
