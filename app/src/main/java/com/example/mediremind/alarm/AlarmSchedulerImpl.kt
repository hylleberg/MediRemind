package com.example.mediremind.alarm

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.util.Log
import java.time.ZoneId

// https://medium.com/@nipunvirat0/how-to-schedule-alarm-in-android-using-alarm-manager-7a1c3b23f1bb

class AlarmSchedulerImpl(private val context: Context): AlarmScheduler {

    private val alarmManager = context.getSystemService(AlarmManager::class.java)

    override fun schedule(alarmItem: AlarmItem) {
        val intent = Intent(context, AlarmReceiver::class.java).apply {
            putExtra("EXTRA_MESSAGE", alarmItem.message)
        }
        val alarmTime = alarmItem.alarmTime.atZone(ZoneId.systemDefault()).toEpochSecond()*1000L
        alarmManager.setExactAndAllowWhileIdle(
            AlarmManager.RTC_WAKEUP,
            alarmTime,
            PendingIntent.getBroadcast(
                context,
                alarmItem.hashCode(),
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            )
        )
        Log.e("Alarm", "Alarm set at $alarmTime")
    }

    override fun snooze(alarmItem: AlarmItem) {
        TODO("Not yet implemented")
    }
}