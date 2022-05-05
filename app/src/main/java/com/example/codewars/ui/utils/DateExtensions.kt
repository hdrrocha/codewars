package com.example.codewars.ui.utils

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

fun Date.format(pattern: String): String {
    return SimpleDateFormat(pattern).format(this)
}

fun Date.add(value: Int, field: Int): Date {
    val myLocale = Locale.getDefault()
    val calendar = Calendar.getInstance(myLocale)
    calendar.time = this
    calendar.add(field, value)
    return calendar.time
}
fun String.toDateDisplay(
    fromPattern: String = "yyyy-mm-dd",
    toPattern: String = "dd/mm/yyyy"
): String {
    val formatter = SimpleDateFormat(fromPattern)
    val formatterOut = SimpleDateFormat(toPattern)
    var date: Date? = null

    return try {
        date = formatter.parse(this)
        formatterOut.format(date)
    } catch (e: ParseException) {
        ""
    }
}
