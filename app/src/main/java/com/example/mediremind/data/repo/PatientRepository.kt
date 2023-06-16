package com.example.mediremind.data.repo


import com.example.mediremind.data.model.MedicineData
import com.example.mediremind.data.model.PatientDataDB

interface PatientRepository {
    suspend fun getUnselectedPatients(): List<PatientDataDB>

    suspend fun getMedicineCollection(id: String): List<MedicineData>
    suspend fun getSelectedPatients(): List<PatientDataDB>

    fun setSelectedPatient(idList: List<String>)
    fun unsetSelectedPatient(idList: List<String>)
}