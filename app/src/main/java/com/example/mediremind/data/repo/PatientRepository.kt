package com.example.mediremind.data.repo

import com.example.mediremind.data.model.PatientData
import com.example.mediremind.data.model.PatientDataDB
import com.example.mediremind.ui.screens.patientlist.model.PatientListState

interface PatientRepository {
    fun getUnselectedPatients(result: (List<PatientDataDB>) -> Unit)

    fun getSelectedPatients(result: (List<PatientDataDB>) -> Unit)

    fun setSelectedPatient(idList: List<String>)
    fun unsetSelectedPatient(idList: List<String>)
}