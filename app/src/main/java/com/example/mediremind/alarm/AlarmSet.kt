package com.example.mediremind.alarm

import android.content.Context
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


fun setAlarm(name: String, medication: String, time: LocalDateTime, context: Context){

    val alarmScheduler: AlarmScheduler = AlarmSchedulerImpl(context)
    var alarmItem: AlarmItem? = null

    val dateTimeFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
    val formattedDate: String = dateTimeFormatter.format(LocalDateTime.now())
    Log.e("asdf", formattedDate)
    alarmItem = AlarmItem(
        alarmTime = time,
        message = "$formattedDate: $name skal have medicin: $medication"
    )
    alarmItem?.let(alarmScheduler::schedule)
}

