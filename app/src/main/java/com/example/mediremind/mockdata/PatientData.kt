package com.example.mediremind.mockdata

import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.graphics.Color
import java.time.LocalDateTime

data class PatientData(val name: String, val assigned: Boolean, val medicindata: List<MedicinData>, val selected: Boolean, val color: Color, val identifier: Int)
    val patientList = listOf(
        PatientData("Henrik Bechmann", false, listOf(
            MedicinData("Paracetamol", LocalDateTime.now().plusSeconds(10)),
            MedicinData("Rexulti", LocalDateTime.now().plusSeconds(5))

        ), false, Color(0xFFD2EE80), 0),
        PatientData("Roger Munckwood", false, listOf(
            MedicinData("Innovair", LocalDateTime.now().plusSeconds(15)),
            MedicinData("Minoxidil", LocalDateTime.now().plusSeconds(20))

        ), false, Color(0xFFD2EE80), 1)


    )
