package com.example.mediremind.ui.screens.medicinelist.model

import com.example.mediremind.data.mockdata.MedicineData
import com.example.mediremind.data.mockdata.medicineTestDataList
import com.example.mediremind.data.model.PatientData
import com.example.mediremind.data.model.patientList

data class MedicineListState(val mList: List<MedicineData> = medicineTestDataList)
