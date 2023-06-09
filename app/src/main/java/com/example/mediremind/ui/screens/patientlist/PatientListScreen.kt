package com.example.mediremind.ui.screens.patientlist

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun PatientListScreen() {
    // Composable, der emitter til UI
    // Kalder til nogle View-model metoder, der hiver data fra en model


    Text(
        text = "Patient list screen!",
        modifier = androidx.compose.ui.Modifier
            .padding(2.dp)
            .fillMaxSize()
            .wrapContentSize()
    )


}

@Preview
@Composable
fun PatientListScreenPreview(){
    Text(
        text = "Patient list screen!",
        modifier = androidx.compose.ui.Modifier
            .padding(2.dp)
            .fillMaxSize()
            .wrapContentSize()
    )

}