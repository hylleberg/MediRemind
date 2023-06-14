package com.example.mediremind.data.model

import android.os.Parcelable
import com.example.mediremind.data.mockdata.MedicineData
import kotlinx.parcelize.Parcelize

data class PatientDataDB(
    val cpr: String = "",
    val name: String = "",
    val identifier: Int = 0,
    val selected: Boolean = false,
    var medicine: List<MedicineData> = listOf()
)
