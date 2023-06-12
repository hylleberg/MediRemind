package com.example.mediremind.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

data class PatientDataDB(
    val cpr: String = "",
    val name: String = "",
    val identifier: Int = 0,
    val selected: Boolean = false
)
