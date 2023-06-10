package com.example.mediremind.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme

import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import java.time.LocalDateTime

import com.example.mediremind.ui.screens.patientlist.PatientListViewModel
import com.example.mediremind.ui.screens.patientlist.model.PatientListState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PatientCard(name: String, patientListState: PatientListState,viewModel: PatientListViewModel) {

    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        colors = CardDefaults.cardColors(containerColor = patientListState.color),
        onClick = {
            if(patientListState.selected == false){
                viewModel.selectCard()
            }else{
                viewModel.unselectCard()
            }



        }
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ){
            Text(
                text = name,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(20.dp)
            )
        }



    }


}