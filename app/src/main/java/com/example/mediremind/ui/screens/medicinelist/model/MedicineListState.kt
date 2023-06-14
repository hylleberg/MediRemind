package com.example.mediremind.ui.screens.medicinelist.model

import com.example.mediremind.data.mockdata.MedicineData
import com.example.mediremind.data.mockdata.medicineTestDataList


data class MedicineListState(val mList: List<MedicineData> = medicineTestDataList)
