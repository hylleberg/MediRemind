package com.example.mediremind.data.model

data class PatientDataDB(
    val cpr: String = "",
    val name: String = "",
    val identifier: Int = 0,
    val selected: Boolean = false,
    var medicine: List<MedicineData> = listOf()
)
