package com.example.mediremind.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme

import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

import com.example.mediremind.data.model.PatientDataDB

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PatientCard(patientModel: PatientDataDB, onItemClick: (Int) -> Unit) {
    val backgroundColor =
        if (!patientModel.selected) MaterialTheme.colorScheme.secondaryContainer else MaterialTheme.colorScheme.secondary
    val borderStroke = if (!patientModel.selected) null else BorderStroke(
        1.dp,
        MaterialTheme.colorScheme.secondary
    )

    val elevation = if (!patientModel.selected) 0.dp else 6.dp

    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
        border = borderStroke,
        elevation = CardDefaults.cardElevation(elevation),
        onClick = {
            onItemClick(patientModel.identifier)
        }
    ) {
        Row(
            verticalAlignment = Alignment.Top,
            modifier = Modifier
                .padding(20.dp),
        )
        {
            Column(modifier = Modifier.fillMaxWidth(0.9f)) {
                Text(
                    text = patientModel.name,
                    style = MaterialTheme.typography.titleMedium,

                    )
                Text(
                    text = patientModel.cpr,
                    style = MaterialTheme.typography.titleSmall,
                )


            }
            Row(
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(imageVector = Icons.Filled.Check, contentDescription = "choose")

            }


        }

    }
}