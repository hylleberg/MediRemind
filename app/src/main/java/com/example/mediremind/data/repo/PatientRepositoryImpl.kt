package com.example.mediremind.data.repo

import android.util.Log
import com.example.mediremind.data.model.MedicineData

import com.example.mediremind.data.model.PatientDataDB
import com.example.mediremind.util.timestampToLocalDateTime
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

class PatientRepositoryImpl @Inject constructor(val database: FirebaseFirestore) :
    PatientRepository {

    override fun getUnselectedPatients(result: (List<PatientDataDB>) -> Unit) {

        database.collection("patientdb").whereEqualTo("selected", false).get()
            .addOnSuccessListener {
                val ptList = arrayListOf<PatientDataDB>()
                for (document in it) {
                    val patient = document.toObject(PatientDataDB::class.java)
                    ptList.add(patient)
                }
                ptList.forEach { list ->
                    getMedicineCollection(list.identifier.toString()) {
                        list.medicine = it
                        Log.d("forEach medColl", it.toString())
                    }
                }

                result.invoke(
                    ptList
                )
                Log.e("firebase", "Successful firebase")
            }
            .addOnFailureListener {
                // return error
                //  error.invoke(
                //         it.localizedMessage
                //      )
                Log.e("firebase", "Failed firebase")
            }
    }

    override fun getMedicineCollection(id: String, result: (List<MedicineData>) -> Unit) {

        database.collection("patientdb").document(id).collection("medicine").get()
            .addOnSuccessListener {
                val medList = arrayListOf<MedicineData>()
                for (document in it) {
                    val med = document.toObject(MedicineData::class.java)
                    medList.add(med)
                }
                medList.forEach { time ->
                    time.alarmtime = timestampToLocalDateTime(time.medtime)
                }
                result.invoke(
                    medList
                )
            }
            .addOnFailureListener {
                // return error
                //  error.invoke(
                //         it.localizedMessage
                //      )
                Log.e("firebase", "Failed firebase, medCollection")
            }


    }

    override fun getSelectedPatients(result: (List<PatientDataDB>) -> Unit) {

        database.collection("patientdb").whereEqualTo("selected", true).get().addOnSuccessListener {
            val ptList = arrayListOf<PatientDataDB>()
            for (document in it) {
                val patient = document.toObject(PatientDataDB::class.java)
                ptList.add(patient)
            }

            ptList.forEach { list ->
                getMedicineCollection(list.identifier.toString()) {
                    list.medicine = it
                    Log.d("forEach medColl", it.toString())
                }
            }

            result.invoke(
                ptList
            )
            Log.e("firebase", "Successful firebase")


        }
            .addOnFailureListener {
                // return error
                //  error.invoke(
                //         it.localizedMessage
                //      )
                Log.e("firebase", "Failed firebase")
            }
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
}


