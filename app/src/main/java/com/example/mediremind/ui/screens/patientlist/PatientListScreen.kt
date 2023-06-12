package com.example.mediremind.ui.screens.patientlist

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mediremind.alarm.setAlarm
import com.example.mediremind.ui.components.PatientCard
import com.example.mediremind.ui.screens.patientlist.model.PatientListState
import java.time.LocalDateTime

@Composable
fun PatientListScreen(viewModel: PatientListViewModel = hiltViewModel()) {
    // Composable, der emitter til UI
    // Kalder til nogle View-model metoder, der hiver data fra en model

    val patientListState = viewModel.state.collectAsState().value
    val context = LocalContext.current

    if (patientListState is PatientListState.Success) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(16.dp)
        ) {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(vertical = 25.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.Top
                ) {
                    Text(
                        text = "Tilgængelige borgere",
                        style = MaterialTheme.typography.headlineMedium
                    )
                }
            }
            items(patientListState.patientList) { patient ->
                PatientCard(patient) {
                    viewModel.onCardClick(it)
                }
            }
        }
        Box(modifier = Modifier.fillMaxSize()) {
            FloatingActionButton(
                modifier = Modifier
                    .padding(all = 16.dp)
                    .align(alignment = Alignment.BottomEnd)
                    .offset(x = -10.dp, y = -70.dp),
                onClick = {
                    viewModel.getDataFromRepository()
                    setAlarm(
                        name = "Hanna",
                        medication = "Kokain",
                        time = LocalDateTime.now().plusSeconds(5),
                        context
                    )
                    Toast.makeText(context, "Click", Toast.LENGTH_SHORT)
                        .show()

                }
            ) {
                Icon(imageVector = Icons.Filled.CheckCircle, contentDescription = "Add")
            }
        }
    } else {
        Column(
            modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator(
                modifier = Modifier.size(size = 64.dp),
                color = MaterialTheme.colorScheme.primary,
                strokeWidth = 6.dp
            )
        }
    }
}
    @Preview
    @Composable
    fun PatientListScreenPreview() {
        Text(
            text = "Patient list screen!",
            modifier = androidx.compose.ui.Modifier
                .padding(2.dp)
                .fillMaxSize()
                .wrapContentSize()
        )

    }