package com.example.mediremind.ui.components

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mediremind.R
import com.example.mediremind.data.model.PatientDataDB
import com.example.mediremind.util.minutesToHourAndMinutes
import com.example.mediremind.util.timestampToLocalDateTime
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.ZoneOffset.UTC

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyPatientsCard(
    patientModel: PatientDataDB,
    onItemClick: (Int) -> Unit,
    onNavigateToMedicineScreen: () -> Unit,
    selectedId: (String) -> Unit
) {

    val borderStroke = if (patientModel.selected) null else BorderStroke(
        1.dp,
        MaterialTheme.colorScheme.secondary
    )
    val medList = patientModel.medicine
    val elevation = if (patientModel.selected) 0.dp else 6.dp


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
            Column(modifier = Modifier.fillMaxWidth(0.6f)) {
                Text(
                    text = patientModel.name,
                    style = MaterialTheme.typography.headlineSmall,


                    )
                Text(
                    text = patientModel.cpr,
                    style = MaterialTheme.typography.titleSmall,
                )
                Spacer(modifier = Modifier.height(20.dp))
                patientModel.medicine.forEach{ medListElement ->
                    val durTime =
                        (timestampToLocalDateTime(medListElement.medtime).toEpochSecond(
                            UTC
                        ) - LocalDateTime.now().toEpochSecond(UTC))/60
                    if(durTime>=0){


                    Row(

                    ){

                        Icon(painter = painterResource(id = R.drawable.acute), contentDescription = "acute", Modifier.size(25.dp))


                        val textColor: Color
                        if(durTime<=60){
                            textColor = Color.Red
                        }else{
                            textColor = Color.Black
                        }
                        Text(
                            text = "  " + minutesToHourAndMinutes(durTime),
                            style = MaterialTheme.typography.titleMedium,
                            color = textColor,
                        )
                    }
                    }else{
                        Log.d("mypatient card", "negative duration, won't post")
                    }

                }


            }

            Column(
                horizontalAlignment = Alignment.End
            ) {

                Row(
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically,
                ) {

                    Button(colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.tertiary), onClick = {
                        onNavigateToMedicineScreen()
                        selectedId(patientModel.identifier.toString())

                    }) {
                        Text(text = "Medicin")
                        Icon(
                            Icons.Filled.KeyboardArrowRight,
                            contentDescription = "gotomedicin",
                             modifier = Modifier.size(20.dp)
                        )

                    }


                }
            }



        }
    }
}

