package com.example.mediremind.ui.screens.patientlist

import android.content.Context
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
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner

import com.example.mediremind.ui.components.PatientCard
import com.example.mediremind.ui.screens.patientlist.model.PatientListState
import java.time.LocalDateTime
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import com.example.mediremind.alarm.setAlarm
import com.example.mediremind.data.model.NavigationItem
import com.example.mediremind.ui.components.Navigation
import com.example.mediremind.ui.screens.mypatients.MyPatientsScreen

@Composable
fun PatientListScreen(
    viewModel: PatientListViewModel = hiltViewModel(),
    onNavigateToMyPatientsScreen: () -> Unit
) {
    // Composable, der emitter til UI
    // Kalder til nogle View-model metoder, der hiver data fra en model


    val patientListState = viewModel.state.collectAsState().value
    val context = LocalContext.current
    val lifecycleEvent = rememberLifecycleEvent()
    /* var isClicked by remember{ mutableStateOf(false)}

     if(isClicked){
         goToScreen(onNavigateToMyPatientsScreen)
     }else{
         Log.e("TIS", "not clicked")
     }*/

    LaunchedEffect(lifecycleEvent) {
        if (lifecycleEvent == Lifecycle.Event.ON_RESUME) {
            viewModel.fetchPatients()
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
                text = "Tilgængelige borgere",
                style = MaterialTheme.typography.headlineMedium
            )
        }
        Column() {
            Text(
                text = "Vælg patienter:",
                style = MaterialTheme.typography.titleLarge
            )
        }
    }

    if (patientListState is PatientListState.Success) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(6.dp),
        ) {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(vertical = 70.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.Top
                ) {}
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
                    var sec: Long = 5
                    val tempIdList = arrayListOf<String>()
                    patientListState.patientList.map {
                        if (it.selected) {
                            it.medicine.forEach { medlist ->
                                setAlarm(
                                    it.name,
                                    medlist.medname,
                                    LocalDateTime.now().plusSeconds(sec),
                                    context
                                )
                                sec += 5
                                Log.d(
                                    "alarmset patientlistscr",
                                    "Set alarm for " + it.name + " for medication " + medlist.medname + " at " + medlist.alarmtime.toString()
                                )

                            }
                            tempIdList.add(it.identifier.toString())

                        } else {
                            Log.e("Assigned lookup", "Couldn't map, not selected")
                        }
                    }

                    viewModel.assignPatient(tempIdList)


                    // isClicked = true;
                    onNavigateToMyPatientsScreen()
                    // goToScreen(viewModel, onNavigateToMyPatientsScreen )

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
                Icon(imageVector = Icons.Filled.CheckCircle, contentDescription = "Add")
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
                Text(text = "Henter patienter...")
            }
        }
    }
}

/*@Composable
fun goToScreen(onNavigateToMyPatientsScreen: () -> Unit ){
    LaunchedEffect(Unit){
        onNavigateToMyPatientsScreen()
    }
}*/

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

