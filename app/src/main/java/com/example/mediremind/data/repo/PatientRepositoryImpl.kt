package com.example.mediremind.data.repo

import com.example.mediremind.data.model.PatientData
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

class PatientRepositoryImpl @Inject constructor(val database: FirebaseFirestore):PatientRepository {


        override fun getPatients(): List<PatientData> {
            TODO()
        }
}