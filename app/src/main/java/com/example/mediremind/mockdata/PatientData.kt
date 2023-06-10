package com.example.mediremind.mockdata

import java.time.LocalDateTime

data class PatientData(val name: String, val assigned: Boolean, val medicindata: List<MedicinData> )
    val patientList = listOf(
        PatientData("Henrik Bechmann", false, listOf(
            MedicinData("Paracetamol", LocalDateTime.now().plusSeconds(10)),
            MedicinData("Rexulti", LocalDateTime.now().plusSeconds(5))

        )),
        PatientData("Roger Munckwood", false, listOf(
            MedicinData("Innovair", LocalDateTime.now().plusSeconds(15)),
            MedicinData("Minoxidil", LocalDateTime.now().plusSeconds(20))

        ))


    )
