package ru.etu.oop.lab6

import java.util.regex.Matcher
import java.util.regex.Pattern

fun validateFloat(fl: String): Boolean {
    val pattern: Pattern = Pattern.compile("^([+-]?\\d*\\.?\\d*)$")
    val matcher: Matcher = pattern.matcher(fl)
    return matcher.matches()
}

fun isFloatZero(string : String) : Boolean {
    try {
        return string.toFloat() == 0F
    }
    catch (e: Exception) {
        return false
    }
}
