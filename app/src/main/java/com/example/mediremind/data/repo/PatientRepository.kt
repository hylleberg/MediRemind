package com.example.mediremind.data.repo

import com.example.mediremind.data.model.PatientData
import com.example.mediremind.data.model.PatientDataDB
import com.example.mediremind.ui.screens.patientlist.model.PatientListState

interface PatientRepository {
    fun getPatients(result: (List<PatientDataDB>) -> Unit)
}