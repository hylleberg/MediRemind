package com.example.mediremind.ui.screens.medicinelist.model

import com.example.mediremind.data.model.MedicineData


sealed interface MedicineListState {

    object Loading : MedicineListState
    data class Failure(val error: Throwable) : MedicineListState
    data class Success(val medicineList: List<MedicineData>) : MedicineListState

}
