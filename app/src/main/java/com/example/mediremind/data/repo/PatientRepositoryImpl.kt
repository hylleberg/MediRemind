package com.example.mediremind.data.repo

import android.util.Log
import com.example.mediremind.data.model.HomeData
import com.example.mediremind.data.model.MedicineData

import com.example.mediremind.data.model.PatientDataDB
import com.example.mediremind.util.timestampToLocalDateTime
import com.google.android.gms.tasks.CancellationTokenSource
import com.google.firebase.Timestamp
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.delay
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class PatientRepositoryImpl @Inject constructor(val database: FirebaseFirestore) :
    PatientRepository {

    override suspend fun getUnselectedPatients(): List<PatientDataDB> {
        val ptList = arrayListOf<PatientDataDB>()
        database.collection("patientdb").whereEqualTo("selected", false).get().await()
            .map { document ->
                val patient = document.toObject(PatientDataDB::class.java)
                ptList.add(patient)
            }
        return ptList
        Log.e("firebase", "Successful firebase")
    }

    override suspend fun getMedicineCollection(id: String): List<MedicineData> {
        val medList = arrayListOf<MedicineData>()
        database.collection("patientdb").document(id).collection("medicine").get().await()
            .map() { document ->
                val med = document.toObject(MedicineData::class.java)
                medList.add(med)
            }
        medList.forEach { time ->
            time.alarmtime = timestampToLocalDateTime(time.medtime)
            Log.d("medlist alarm put", "did it")
        }
        return medList
    }


    override suspend fun getSelectedPatients(): List<PatientDataDB> {
        val ptList = arrayListOf<PatientDataDB>()
        database.collection("patientdb").whereEqualTo("selected", true).get().await()
            .map { document ->
                val patient = document.toObject(PatientDataDB::class.java)
                ptList.add(patient)
            }
        return ptList

        Log.e("firebase", "Successful firebase")


    }


    override fun setSelectedPatient(idList: List<String>) {
        idList.forEach {
            val ref = database.collection("patientdb").document(it)
            ref.update("selected", true)
        }
    }

    override fun unsetSelectedPatient(idList: List<String>) {
        idList.forEach {
            val ref = database.collection("patientdb").document(it)
            ref.update("selected", false)
        }
    }

    override fun setMedicineTime(update: HomeData){

        val ref = database.collection("patientdb").document(update.id).collection("medicine").document(update.medId)
        ref.update("medtime", update.medtime)

        Log.d("repo set time", "set time!" + update.medtime)


    }
}


