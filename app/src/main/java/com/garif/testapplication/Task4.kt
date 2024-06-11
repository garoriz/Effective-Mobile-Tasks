package com.garif.testapplication

fun main() {
    val list = listOf(3, null, 1, 4, null, 2)
    val sortedList = sort(list)
    println(sortedList)
}

fun sort(list: List<Int?>?): List<Int?>? {
    if (list == null) return null

    val mutableList = list.toMutableList()
    var left = 0
    var right = mutableList.size - 1

    while (left < right) {
        var newRight = left
        var newLeft = right

        for (i in left until right) {
            if (compare(mutableList[i], mutableList[i + 1]) > 0) {
                mutableList.swap(i, i + 1)
                newRight = i
            }
        }
        right = newRight

        for (i in right downTo  left + 1) {
            if (compare(mutableList[i - 1], mutableList[i]) > 0) {
                mutableList.swap(i - 1, i)
                newLeft = i
            }
        }
        left = newLeft
    }

    return mutableList
}

private fun compare(a: Int?, b: Int?): Int {
    return when {
        a == null && b == null -> 0
        a == null -> 1
        b == null -> -1
        else -> a.compareTo(b)
    }
}

private fun MutableList<Int?>.swap(index1: Int, index2: Int) {
    val temp = this[index1]
    this[index1] = this[index2]
    this[index2] = temp
}