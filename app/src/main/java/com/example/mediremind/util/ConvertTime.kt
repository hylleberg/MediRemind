package com.example.mediremind.util

import android.util.Log
import androidx.compose.material3.MaterialTheme
import com.google.firebase.Timestamp
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter



fun timestampToLocalDateTime(timestamp: Timestamp): LocalDateTime {
    val tempTimestamp = timestamp.seconds * 1000
    Log.d("timestamp", tempTimestamp.toString())
    return LocalDateTime.ofInstant(Instant.ofEpochMilli(tempTimestamp), ZoneId.systemDefault())

}