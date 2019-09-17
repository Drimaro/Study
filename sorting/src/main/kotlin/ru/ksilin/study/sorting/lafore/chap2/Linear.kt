package ru.ksilin.study.sorting.lafore.chap2

internal class HighArray(max: Int) {
    private val a: LongArray = LongArray(max)
    private var nElems: Int = 0

    fun find(searchKey: Long): Boolean {
        var j = 0
        while (j < nElems) {
            // for each element,
            if (a[j] == searchKey)
            // found item?
                break
            j++
        }
        return j == nElems
    }

    fun insert(value: Long)
    {
        a[nElems] = value
        nElems++
    }

    fun delete(value: Long): Boolean {
        var j = 0
        while (j < nElems) {
            if (value == a[j])
                break
            j++
        }
        if (j == nElems)
            return false
        else
        {
            for (k in j until nElems)
                a[k] = a[k + 1]
            nElems--
            return true
        }
    }

    fun display()
    {
        for (j in 0 until nElems)
            print(a[j].toString() + " ")
        println()

    }

    fun getMax() : Long {
        var max = -1L

        for (i in 0 until nElems) {
            if (a[i] > max)
                max = a[i]
        }
        println("Max element = $max")
        return max
    }

    fun removeMax() : Long {
        var max = -1L

        for (i in 0 until nElems) {
            if (a[i] > max)
                max = a[i]
        }
        if (max > -1) {
            println("Max element = $max")
            delete(max)
        }
        return max
    }

    fun noDups() {
        if (nElems == 0) return

        for (i in 0 until nElems) {
            val currentElement = a[i]
            if (currentElement == -1L) continue
            for (j in i+1..nElems) {
                if (currentElement == a[j]) {
                    a[j] = -1 // not meaningful value as array only for positive
                }
            }
        }
        var id = 0
        var toSet = 0
        var removed = 0
        do {
            if (a[id] == -1L) {
                removed++
            } else {
                a[toSet] = a[id]
                toSet++
            }
            id++
        } while (id < nElems)
        nElems -= removed
    }
}

fun main() {
    val maxSize = 100            // array size
    val arr: HighArray                // reference to array
    arr = HighArray(maxSize) // create the array

    for (i in 0..4) {
        arr.insert(i.toLong())
        arr.insert(i.toLong())
        arr.insert(i.toLong())
        arr.insert(i.toLong())
    }
    arr.display()
    arr.noDups()
    arr.display()
}

fun ex1() {
    val maxSize = 100            // array size
    val arr: HighArray                // reference to array
    arr = HighArray(maxSize) // create the array

    arr.insert(77)               // insert 10 items
    arr.insert(99)
    arr.insert(44)
    arr.insert(55)
    arr.insert(22)
    arr.insert(88)
    arr.insert(11)
    arr.insert(0)
    arr.insert(66)
    arr.insert(133)
    arr.insert(33)

    arr.display()                // display items

    val searchKey = 35           // search for item
    if (arr.find(searchKey.toLong()))
        println("Found $searchKey")
    else
        println("Can't find $searchKey")

    arr.delete(0)               // delete 3 items
    arr.delete(55)
    arr.delete(133)

    arr.display()
    val sortedArr = HighArray(maxSize)

    var removedMax = arr.removeMax()
    while (removedMax > -1) {
        sortedArr.insert(removedMax)
        removedMax = arr.removeMax()
    }
    sortedArr.display()
}
