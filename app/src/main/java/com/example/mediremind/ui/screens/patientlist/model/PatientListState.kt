package com.example.mediremind.ui.screens.patientlist.model


import com.example.mediremind.data.mockdata.MedicineData
import com.example.mediremind.data.model.PatientDataDB


sealed interface PatientListState {

    object Loading: PatientListState
    data class Failure(val error: Throwable): PatientListState
    data class Success(val patientList:  List<PatientDataDB>): PatientListState

    data class Success2(val medList:  List<MedicineData>): PatientListState

}

