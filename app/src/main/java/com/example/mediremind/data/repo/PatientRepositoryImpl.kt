package com.example.mediremind.data.repo

import android.util.Log
import com.example.mediremind.data.model.PatientData
import com.example.mediremind.data.model.PatientDataDB
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

class PatientRepositoryImpl @Inject constructor(val database: FirebaseFirestore):PatientRepository {

        override fun getPatients() {
                database.collection("patientdb")
                .get().addOnSuccessListener {
                    val ptList = arrayListOf<PatientDataDB>()
                        for (document in it) {
                            val patient = document.toObject(PatientDataDB::class.java)
                            ptList.add(patient)
                        }
                        // return List<PatientDataDB>, success case

                        Log.e("firebase", "Successful firebase")
                        Log.e("firebase-data", ptList[0].name.toString())
                        Log.e("firebase-data", ptList[1].name.toString())
                        Log.e("firebase-data", ptList[2].name.toString())
            }
                    .addOnFailureListener{
                        // return error
                        Log.e("firebase", "Failed firebase")
                    }
        }
}