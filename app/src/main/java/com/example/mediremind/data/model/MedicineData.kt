package com.example.mediremind.data.model

import android.icu.text.TimeZoneFormat.GMTOffsetPatternType
import com.example.mediremind.alarm.AlarmItem
import com.example.mediremind.util.timestampToLocalDateTime
import com.google.firebase.Timestamp
import com.google.firebase.firestore.ServerTimestamp
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZoneId.systemDefault
import java.time.ZoneOffset
import java.time.ZoneOffset.UTC
import java.util.Date

data class MedicineData(
    val medname: String = "",
    val meddose: String = "",
    val medexp: String = "",
    @ServerTimestamp
    val medtime: Timestamp = Timestamp.now(),
    var alarmtime: LocalDateTime = timestampToLocalDateTime(medtime),
    val medadm: String = ""
)


/*  val medicineTestDataList = listOf(
      MedicineData("Hash, 5g", "2 skiver", "asfasd",  "Oralt"),
      MedicineData("Kakao, 50ml", "2 slurke", "asdgdfs",  "Oralt")
)*/
