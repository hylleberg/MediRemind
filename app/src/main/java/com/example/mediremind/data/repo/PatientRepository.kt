package com.example.mediremind.data.repo

import com.example.mediremind.data.model.PatientData

interface PatientRepository {
    fun getPatients()
    //: List<PatientData>
}