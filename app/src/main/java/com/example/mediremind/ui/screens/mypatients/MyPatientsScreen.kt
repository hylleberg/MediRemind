package com.example.mediremind.ui.screens.mypatients

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import com.example.mediremind.alarm.setAlarm
import com.example.mediremind.data.mockdata.testDataList
import com.example.mediremind.ui.components.MyPatientsCard
import com.example.mediremind.ui.components.PatientCard
import com.example.mediremind.ui.screens.mypatients.model.MyPatientsScreenState
import com.example.mediremind.ui.screens.patientlist.PatientListViewModel
import com.example.mediremind.ui.screens.patientlist.model.PatientListState

import java.time.LocalDateTime

@Composable
fun MyPatientsScreen(viewModel: MyPatientsScreenViewModel = hiltViewModel(), onNavigateToMedicineScreen: () -> Unit) {


    val myPatientScreenState = viewModel.state.collectAsState().value
    val context = LocalContext.current
    val lifecycleEvent = rememberLifecycleEvent()

    LaunchedEffect(lifecycleEvent) {
        if (lifecycleEvent == Lifecycle.Event.ON_RESUME) {
            viewModel.fetchAssignedPatients()
        }
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(vertical = 25.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.Top
        ) {
            Text(
                text = "Mine patienter",
                style = MaterialTheme.typography.headlineMedium
            )
        }

    }
    if (myPatientScreenState is MyPatientsScreenState.Success) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(16.dp)
        ) {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(vertical = 40.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.Top
                ) {}
                Button(onClick = {

                    onNavigateToMedicineScreen()

                }){
                    Text(text = "KNAP")


                }
            }
            items(myPatientScreenState.patientList) { patient ->
                MyPatientsCard(patient) {
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
                containerColor = MaterialTheme.colorScheme.error,
                onClick = {
                    val tempIdList = arrayListOf<String>()
                    myPatientScreenState.patientList.map {
                        if (!it.selected) {
                            tempIdList.add(it.identifier.toString())
                        } else {
                            Log.e("Assigned lookup", "Couldn't map, not selected")
                        }
                    }
                    tempIdList.forEach {
                        Log.e("asdgas", it)

                    }
                    viewModel.unassignPatient(tempIdList)

                    /* setAlarm(
                         name = "Hanna",
                         medication = "Kokain",
                         time = LocalDateTime.now().plusSeconds(5),
                         context
                     )
                     Toast.makeText(context, "Click", Toast.LENGTH_SHORT)
                         .show()*/

                }
            ) {
                Icon(imageVector = Icons.Filled.Delete, contentDescription = "Add")
            }
        }


    } else {
        Column(
            modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                CircularProgressIndicator(
                    modifier = Modifier.size(size = 28.dp),
                    color = MaterialTheme.colorScheme.primary,
                    strokeWidth = 6.dp
                )
                Spacer(modifier = Modifier.width(width = 8.dp))
                Text(text = "Henter ansvarliste...")
            }
        }
    }
}

@Composable
fun rememberLifecycleEvent(lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current): Lifecycle.Event {
    var state by remember { mutableStateOf(Lifecycle.Event.ON_ANY) }
    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            state = event
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }
    return state
}