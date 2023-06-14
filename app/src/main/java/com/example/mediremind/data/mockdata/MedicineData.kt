package com.example.mediremind.data.mockdata

import com.google.firebase.firestore.ServerTimestamp
import java.time.LocalDateTime
import java.util.Date

data class MedicineData(
    val medname: String = "",
    val meddose: String = "",
    val medexp: String = "",
  //  @ServerTimestamp
  //  val medtime: Date? = null,
    val medadm: String = "")


    val medicineTestDataList = listOf(
        MedicineData("Hash, 5g", "2 skiver", "asfasd",  "Oralt"),
        MedicineData("Kakao, 50ml", "2 slurke", "asdgdfs",  "Oralt")
)
