package com.example.mediremind.ui.screens.patientlist.model

import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.graphics.Color
import com.example.mediremind.mockdata.MedicinData
import com.example.mediremind.mockdata.PatientData
import com.example.mediremind.mockdata.patientList
import java.time.LocalDateTime

data class PatientListState(val pList: List<PatientData> = patientList)



