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
            MedicineData("Paracetamol", "1 tabl.", LocalDateTime.now().plusSeconds(10), "Oralt"),
            MedicineData("Rexulti", "2 tabl.",  LocalDateTime.now().plusSeconds(5), "Rektalt")

        ), false, 0
    ),
    PatientData(
        "987654321","Roger Munckwood", false, listOf(
            MedicineData("Innovair", "3 kg.",  LocalDateTime.now().plusSeconds(15), "i.m."),
            MedicineData("Minoxidil", "1 sprøjte", LocalDateTime.now().plusSeconds(20), "i.v.")

        ), false, 1
    )


)
