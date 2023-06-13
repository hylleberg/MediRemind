package com.example.mediremind.data.mockdata

import java.time.LocalDateTime

data class MedicineData(val medication: String, val dose: String, val time: LocalDateTime, val medadm: String)
    val medicineTestDataList = listOf(
        MedicineData("Hash, 5g", "2 skiver", LocalDateTime.now(), "Oralt"),
        MedicineData("Kakao, 50ml", "2 slurke", LocalDateTime.now(), "Oralt")
)
