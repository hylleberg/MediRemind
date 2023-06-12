package com.example.mediremind.data.model

import com.example.mediremind.data.mockdata.MedicineData
import java.time.LocalDateTime

data class PatientData(
    val CPR: String,
    val name: String,
    val assigned: Boolean,
    val medication: List<MedicineData>,
    val selected: Boolean,
    val identifier: Int
)


val patientList = listOf(
    PatientData(
        "123456789","Henrik Bechmann", false, listOf(
            MedicineData("Paracetamol", LocalDateTime.now().plusSeconds(10)),
            MedicineData("Rexulti", LocalDateTime.now().plusSeconds(5))

        ), false, 0
    ),
    PatientData(
        "987654321","Roger Munckwood", false, listOf(
            MedicineData("Innovair", LocalDateTime.now().plusSeconds(15)),
            MedicineData("Minoxidil", LocalDateTime.now().plusSeconds(20))

        ), false, 1
    )


)
