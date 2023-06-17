package com.example.mediremind.util

import android.util.Log
import androidx.compose.material3.MaterialTheme
import com.google.firebase.Timestamp
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter



fun timestampToLocalDateTime(timestamp: Long): LocalDateTime {
    val tempTimestamp = timestamp * 1000
    Log.d("timestamp", tempTimestamp.toString())
    return LocalDateTime.ofInstant(Instant.ofEpochMilli(tempTimestamp), ZoneId.systemDefault())

}

fun minutesToHourAndMinutes(duration: Long): String{
    val hours: Int = duration.toInt() / 60
    val minutes: Int = duration.toInt() % 60

    if(hours==0){
        return "$minutes mins "
    }else if(minutes==0){
        return "$hours timer"
    }else{
        return "$hours timer, $minutes mins "
    }
}
