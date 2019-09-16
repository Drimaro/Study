package ru.ksilin.study.sorting.lafore.chap2

import java.util.*

class Arr(size: Int) {

    private val innerArray = LongArray(size)
    private var nElement = 0

    fun find(searchKey: Long): Int {
        var left = 0
        var right = nElement - 1
        if (left > right) return -1
        var idx: Int
        do {
            idx = (right + left) / 2
            if (innerArray[idx] == searchKey) return idx

            if (innerArray[idx] > searchKey)
                right = idx - 1
            else
                left = idx + 1
        } while (left <= right)
        if (innerArray[idx] < searchKey) idx++
        var resultIdx = -1 * idx - 1
        if (false) {
            display()
            println("Final index for element ${searchKey} = $resultIdx")
        }
        return resultIdx
    }

    fun insert(value: Long) {
        if (nElement >= innerArray.size) {
            println("Array is full. Can't insert new value.")
            return
        }

        val idx = find(value)
        if (idx >= 0)
            println("Value $value already in array.")
        else {
            val targetIdx = -1 * idx - 1
            for (i in nElement downTo targetIdx+1) {
                innerArray[i] = innerArray[i-1]
            }
            innerArray[targetIdx] = value
            nElement++
        }
    }

    fun delete(value: Long): Boolean {
        if (nElement <= 0) return false
        val idx = find(value)
        if (idx >= 0) {
            val toDeleteIdx = -1 * idx + 1
            for (i in toDeleteIdx until nElement)
                innerArray[i] = innerArray[i+1]
            nElement--
            return true
        }
        return false
    }

    fun display() {
        (0 until nElement).forEach { print("${innerArray[it]} ") }
        println()
    }

    fun size(): Int {
        return nElement
    }

    fun merge(toMerge: Arr): Arr {
        if (toMerge.size() == 0) return this
        if (size() == 0) return toMerge
        val arr = Arr(size() + toMerge.size())
        var i = 0
        var j = 0

        while (i < size() && j < toMerge.size()) {
            if (innerArray[i] < toMerge.innerArray[j]) {
                arr.innerArray[arr.nElement] = innerArray[i]
                i++
            } else if (innerArray[i] == toMerge.innerArray[j]) {
                arr.innerArray[arr.nElement] = innerArray[i]
                i++; j++
            } else {
                arr.innerArray[arr.nElement] = toMerge.innerArray[j]
                j++
            }
            arr.nElement++
        }

        while (i < size()) arr.innerArray[arr.nElement++] = innerArray[i++]
        while (j < toMerge.size()) arr.innerArray[arr.nElement++] = toMerge.innerArray[j++]
        return arr
    }
}

fun main(args: Array<String>) {
    val maxSize = 100             // array size
    val arr1 = Arr(maxSize)   // create the array
    for (i in 0..9) {
        arr1.insert(Random().nextInt(100).toLong())
    }

    arr1.display()

    val arr2 = Arr(14)
    for (i in 0 until 14) arr2.insert(Random().nextInt(100).toLong())
    arr2.display()

    val merged = arr1.merge(arr2)
    merged.display()
}