package com.example.mediremind.data.mockdata

import java.time.LocalDateTime

data class MedicineData(val medication: String, val time: LocalDateTime)
    val medicineTestDataList = listOf(
        MedicineData("hash" , LocalDateTime.now()),
        MedicineData("kakao", LocalDateTime.now())
)
