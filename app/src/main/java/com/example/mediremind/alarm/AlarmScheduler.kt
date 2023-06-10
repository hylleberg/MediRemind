package com.example.mediremind.alarm

interface AlarmScheduler {
    fun schedule(alarmItem: AlarmItem)
    fun snooze(alarmItem: AlarmItem)
}