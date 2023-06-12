package com.example.mediremind.data.model

import com.example.mediremind.data.mockdata.MedicinData
import java.time.LocalDateTime

data class PatientData(
    val CPR: String,
    val name: String,
    val assigned: Boolean,
    val medication: List<MedicinData>,
    val selected: Boolean,
    val identifier: Int
)


val patientList = listOf(
    PatientData(
        "123456789","Henrik Bechmann", false, listOf(
            MedicinData("Paracetamol", LocalDateTime.now().plusSeconds(10)),
            MedicinData("Rexulti", LocalDateTime.now().plusSeconds(5))

        ), false, 0
    ),
    PatientData(
        "987654321","Roger Munckwood", false, listOf(
            MedicinData("Innovair", LocalDateTime.now().plusSeconds(15)),
            MedicinData("Minoxidil", LocalDateTime.now().plusSeconds(20))

        ), false, 1
    )


)
