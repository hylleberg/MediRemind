package com.example.mediremind.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme

import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mediremind.data.model.PatientData
import com.example.mediremind.data.model.PatientDataDB

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PatientCard(patientModel: PatientDataDB, onItemClick: (Int) -> Unit) {
    val backgroundColor = if(!patientModel.selected) MaterialTheme.colorScheme.secondaryContainer else MaterialTheme.colorScheme.secondary


    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        colors = CardDefaults.cardColors(containerColor = backgroundColor),
        onClick = {
            onItemClick(patientModel.identifier)
        }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = patientModel.name,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(20.dp)
            )
        }


    }

}