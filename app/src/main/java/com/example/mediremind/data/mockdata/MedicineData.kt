package com.example.mediremind.data.mockdata

import java.time.LocalDateTime

data class MedicineData(val medication: String, val dose: String, val time: LocalDateTime, val medadm: String)
    val medicineTestDataList = listOf(
        MedicineData("Hash, 5 gram", "2 skiver", LocalDateTime.now(), "Oralt"),
        MedicineData("Kakao, 50 ml", "2 slurke", LocalDateTime.now(), "Oralt")
)
