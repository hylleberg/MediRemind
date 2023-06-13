package com.example.mediremind.ui.screens.mypatients.model

import com.example.mediremind.data.model.PatientDataDB
import com.example.mediremind.ui.screens.patientlist.model.PatientListState

sealed interface MyPatientsScreenState {
    object Loading: MyPatientsScreenState
    data class Failure(val error: Throwable): MyPatientsScreenState
    data class Success(val patientList:  List<PatientDataDB>): MyPatientsScreenState
}