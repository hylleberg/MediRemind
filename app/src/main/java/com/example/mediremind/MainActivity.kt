package com.example.mediremind

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mediremind.ui.theme.MediRemindTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MediRemindTheme {
                Surface(color = MaterialTheme.colorScheme.background) {

                    Scaffold(
                        topBar = { TopAppBar(
                            title = {Text("Ledige beboere", fontSize = 30.sp, fontWeight = FontWeight.W700, modifier = Modifier.padding(10.dp), color = Color.White)}, colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary))},
                        floatingActionButtonPosition = FabPosition.Center,
                        floatingActionButton = { ExtendedFloatingActionButton(
                            onClick = { /* do something */ },
                            icon = { Icon(Icons.Filled.CheckCircle, "placeholder", Modifier, Color.Green)},
                            text = { Text(text = "Bekræft valg")},
                            containerColor = MaterialTheme.colorScheme.primary,
                        ) },


                        bottomBar = {
                                    BottomAppBar(containerColor = MaterialTheme.colorScheme.primary) {
                                        androidx.compose.material3.NavigationBar(
                                            containerColor = MaterialTheme.colorScheme.primary,
                                        ) {
                                            bottomNavItems.forEach { item ->
                                                val selected = false

                                                NavigationBarItem(
                                                    selected = selected,
                                                    onClick = { },
                                                    label = {
                                                        Text(
                                                            text = item.name,
                                                            fontWeight = FontWeight.SemiBold,
                                                            color = Color.Black

                                                        )
                                                    },
                                                    icon = {
                                                        Icon(
                                                            imageVector = item.icon,
                                                            contentDescription = "${item.name} Icon",
                                                            Modifier,
                                                            Color.Black
                                                        )
                                                    }
                                                )
                                            }
                                        }

                                    }

                        },
                        content = {PatientListFree(patients)},
                    )
                }
            }
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PatientListFree(patients: List<PatientData>) {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        Text("Ledige beboere", fontSize = 30.sp, fontWeight = FontWeight.W700, modifier = Modifier.padding(10.dp))
        patients.forEach { patientdata ->
            if(patientdata.free == true){
                PatientRow(patientdata)
            }
        }
        Row(){
            Column(verticalArrangement = Arrangement.Bottom) {


                }
            }


        }
    }


@Composable
fun PatientListTaken(patients: List<PatientData>) {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        Text("Allerede tilknyttet", fontSize = 30.sp, fontWeight = FontWeight.W700, modifier = Modifier.padding(10.dp))
        patients.forEach { patientdata ->
            if(patientdata.free == false){

            }

        }
    }
}

@Composable
fun PatientRow(patientdata: PatientData){

    Card(modifier = Modifier
        .padding(all = 10.dp)
        .fillMaxWidth(), shape = RoundedCornerShape(20.dp), border = BorderStroke(1.dp, Color.Black), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)) {
        Row(verticalAlignment = Alignment.CenterVertically){
        Image(painter = painterResource(id = patientdata.pic), contentDescription = "", contentScale = ContentScale.Crop,            // crop the image if it's not a square
            modifier = Modifier
                .padding(16.dp)
                .size(64.dp)
                .clip(CircleShape)
                .border(2.dp, Color.Gray, CircleShape)
                )
        Column(modifier = Modifier
            .padding(all = 10.dp)
            .fillMaxWidth()
            .weight(1f)) {
            Text(patientdata.name, fontSize = 20.sp, fontWeight = FontWeight.W700, modifier = Modifier.padding(10.dp))
            Text(patientdata.cpr, color = Color.Black, modifier = Modifier.padding(10.dp))
        }
        Column() {
            val contextForToast = LocalContext.current.applicationContext
            var checked by remember {
                mutableStateOf(false)
            }

            Checkbox(
                checked = checked,
                onCheckedChange = { checked_ ->
                    checked = checked_
                    Toast.makeText(contextForToast, "checked_ = $checked_", Toast.LENGTH_SHORT).show()
                }
            )
        }

    }
    }
}


