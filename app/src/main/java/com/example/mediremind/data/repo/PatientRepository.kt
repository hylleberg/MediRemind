package com.example.mediremind.data.repo


import com.example.mediremind.data.model.MedicineData
import com.example.mediremind.data.model.PatientDataDB

interface PatientRepository {
    fun getUnselectedPatients(result: (List<PatientDataDB>) -> Unit)

    fun getMedicineCollection(id: String, result: (List<MedicineData>) -> Unit)
    fun getSelectedPatients(result: (List<PatientDataDB>) -> Unit)

    fun setSelectedPatient(idList: List<String>)
    fun unsetSelectedPatient(idList: List<String>)
}