package com.example.mediremind.data.repo

import android.util.Log
import com.example.mediremind.data.model.PatientData
import com.example.mediremind.data.model.PatientDataDB
import com.example.mediremind.ui.screens.patientlist.model.PatientListState
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
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
                // return List<PatientDataDB>, success case
                result.invoke(
                    ptList
                )
                Log.e("firebase", "Successful firebase")
                //   Log.e("firebase-data", ptList[0].name)
                //   Log.e("firebase-data", ptList[1].name)
                //    Log.e("firebase-data", ptList[2].name)
            }
            .addOnFailureListener {
                // return error
                //  error.invoke(
                //         it.localizedMessage
                //      )
                Log.e("firebase", "Failed firebase")
            }
    }

    override fun getSelectedPatients(result: (List<PatientDataDB>) -> Unit) {

        database.collection("patientdb").whereEqualTo("selected", true).get().addOnSuccessListener {
            val ptList = arrayListOf<PatientDataDB>()
            for (document in it) {
                val patient = document.toObject(PatientDataDB::class.java)
                ptList.add(patient)
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


