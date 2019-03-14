package io.redspark.redstest.extensions

import java.text.SimpleDateFormat
import java.util.*

const val TIMEZONE_GMT = "GMT"

fun Date.stringFormattedDate(pattern: String?): String {
    val dateFormat = SimpleDateFormat(pattern, Locale.getDefault())
    dateFormat.timeZone = TimeZone.getTimeZone(TIMEZONE_GMT)
    return String.format(dateFormat.format(this))
}