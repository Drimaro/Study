package ru.ksilin.study.sorting.lafore.chap2

import java.util.*

internal class OrdArray (max: Int) {
    private val a: LongArray = LongArray(max)
    private var nElems: Int = 0               // number of data items

    fun size(): Int {
        return nElems
    }

    fun find(searchKey: Long): Int {
        var lowerBound = 0
        var upperBound = nElems - 1
        var curIn: Int

        while (true) {
            curIn = (lowerBound + upperBound) / 2
            if (a[curIn] == searchKey)
                return curIn              // found it
            else if (lowerBound > upperBound)
                return nElems             // can't find it
            else
            // divide range
            {
                if (a[curIn] < searchKey)
                    lowerBound = curIn + 1 // it's in upper half
                else
                    upperBound = curIn - 1 // it's in lower half
            }  // end else divide range
        }  // end while
    }  // end find()

    fun insert(value: Long)    // put element into array
    {
        var lowerBound = 0
        var upperBound = nElems - 1
        var id: Int

        while (true) {
            id = (lowerBound + upperBound) / 2
            if (a[id] == value) // already exists do not add
                return
            else if (lowerBound > upperBound) {
                if (nElems > 0) {
                    val possibleId = if (a[id] < value)  id + 1 else id
                    for (k in nElems downTo possibleId + 1)
                    // move bigger ones up
                        a[k] = a[k - 1]
                    a[possibleId] = value
                } else {
                    a[id] = value
                }
                nElems++
                return
            } else {
                if (a[id] < value) {
                    lowerBound = id + 1
                } else {
                    upperBound = id - 1
                }
            }
        }
    }  // end insert()

    fun delete(value: Long): Boolean {
        val j = find(value)
        return if (j == nElems)
        // can't find it
            false
        else
        // found it
        {
            for (k in j until nElems)
            // move bigger ones down
                a[k] = a[k + 1]
            nElems--                   // decrement size
            true
        }
    }

    fun display()
    {
        for (j in 0 until nElems)
            print(a[j].toString() + " ")
        println("")
    }

    fun merge(param: OrdArray): LongArray {
        val result = LongArray(nElems + param.nElems)
        var i = 0
        var thisI = 0
        var paramI = 0
        while (thisI < nElems && paramI < param.nElems) {
            if (a[thisI] == param.a[paramI]) {
                result[i] = a[thisI]
                thisI++
                paramI++
            } else if(a[thisI] < param.a[paramI]) {
                result[i] = a[thisI]
                thisI++
            } else {
                result[i] = param.a[paramI]
                paramI++
            }
            i++
        }
        if (paramI < param.nElems) {
            for (j in paramI until param.nElems) {
                result[i] = param.a[paramI]
                i++
            }
        }
        if (thisI < nElems) {
            for (j in thisI until nElems) {
                result[i] = a[thisI]
                i++
            }
        }
        return result
    }
}

fun main(args: Array<String>) {
    val maxSize = 100             // array size
    val arr1 = OrdArray(maxSize)   // create the array
    for (i in 0..9) {
        arr1.insert(Random().nextInt(100).toLong())
    }
    arr1.display()

    val arr2 = OrdArray(maxSize)   // create the array
    for (i in 0..19) {
        arr2.insert(Random().nextInt(100).toLong())
    }
    arr2.display()
    val merge = arr1.merge(arr2)
    println(Arrays.toString(merge))


/*
    arr.insert(77)                // insert 10 items
    arr.insert(99)
    arr.insert(44)
    arr.insert(55)
    arr.insert(22)
    arr.insert(88)
    arr.insert(11)
    arr.insert(0)
    arr.insert(66)
    arr.insert(33)

    val searchKey = 55            // search for item
    if (arr.find(searchKey.toLong()) != arr.size())
        println("Found $searchKey")
    else
        println("Can't find $searchKey")

    arr.display()                 // display items

    arr.delete(0)                // delete 3 items
    arr.delete(55)
    arr.delete(99)

    arr.display()
*/
}