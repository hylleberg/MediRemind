package com.example.mediremind.ui.screens.home.model

import com.example.mediremind.PatientData
import com.example.mediremind.patients

data class HomeScreenState(
    val counter:Int = 3,
    val title:String = "test state",
    val patientList:List<PatientData> = patients
)
