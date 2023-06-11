package com.example.mediremind.ui.screens.patientlist.model

import com.example.mediremind.data.model.PatientData
import com.example.mediremind.data.model.patientList

data class PatientListState(val pList: List<PatientData> = patientList)



