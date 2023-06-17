package com.example.mediremind.data.repo


import com.example.mediremind.data.model.HomeData
import com.example.mediremind.data.model.MedicineData
import com.example.mediremind.data.model.PatientDataDB
import com.google.firebase.Timestamp

interface PatientRepository {
    suspend fun getUnselectedPatients(): List<PatientDataDB>

    suspend fun getMedicineCollection(id: String): List<MedicineData>
    suspend fun getSelectedPatients(): List<PatientDataDB>

    fun setSelectedPatient(idList: List<String>)
    fun unsetSelectedPatient(idList: List<String>)

    fun setMedicineTime(update: HomeData)
}