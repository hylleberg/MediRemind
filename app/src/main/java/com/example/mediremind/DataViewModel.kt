package com.example.mediremind.presentation.data.screen

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mediremind.data.model.Patients
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class DataViewModel: ViewModel(){
    val state = mutableStateOf(Patients())

    init {
        getData()
    }

    private fun getData(){
        viewModelScope.launch {

        }
    }
}

suspend fun getDataFromFirestore():Patients{
    val db = FirebaseFirestore.getInstance()
    var patients = Patients()

    try {
        db.collection("Patients").get().await().map{
            val result = it.toObject(Patients::class.java)
                patients = result
        }

    } catch (e: FirebaseFirestoreException) {
        Log.d("error", "getDataFromFirestore: $e")

    }
    return patients
}

