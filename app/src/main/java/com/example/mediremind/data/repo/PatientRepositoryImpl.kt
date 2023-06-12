package com.example.mediremind.data.repo

import android.util.Log
import com.example.mediremind.data.model.PatientData
import com.example.mediremind.data.model.PatientDataDB
import com.example.mediremind.ui.screens.patientlist.model.PatientListState
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

class PatientRepositoryImpl @Inject constructor(val database: FirebaseFirestore):PatientRepository {

        override fun getPatients(result: (List<PatientDataDB>) -> Unit) {
                database.collection("patientdb")
                .get().addOnSuccessListener {
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
                    .addOnFailureListener{
                        // return error
                      //  error.invoke(
                       //         it.localizedMessage
                      //      )
                        Log.e("firebase", "Failed firebase")
                    }
        }
}