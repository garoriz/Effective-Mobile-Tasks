package com.garif.testapplication


// В MainActivity создание списка и запись лога
fun List<*>.getInt(): Int? {
    for (item in this) {
        if (item is Int) {
            return item
        }
    }
    return null
}