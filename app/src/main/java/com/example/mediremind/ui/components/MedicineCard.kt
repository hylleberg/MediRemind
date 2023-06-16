package com.example.mediremind.ui.components

import android.util.Log
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.*
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.wear.compose.material3.ContentAlpha
import com.example.mediremind.data.model.MedicineData
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.TimeZone

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MedicineCard(medicineModel: MedicineData) {
    var expandedState by remember { mutableStateOf(false) }
    val rotationState by animateFloatAsState(
        targetValue = if (expandedState) 180f else 0f
    )

    val dateTimeFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
    val convTime: String = dateTimeFormatter.format(medicineModel.alarmtime)

    val backgroundColor = MaterialTheme.colorScheme.secondaryContainer

    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            // .wrapContentHeight()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            ),
        // shape = RoundedCornerShape(0.dp),
        colors = CardDefaults.cardColors(containerColor = backgroundColor),

        onClick = {
            expandedState = !expandedState
        }


    ) {
        Row(
            verticalAlignment = Alignment.Top,
            modifier = Modifier
                .padding(20.dp),
        ){


        Column(
            modifier = Modifier
                .fillMaxWidth(0.7f)
            // .padding(12.dp)

        ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        modifier = Modifier
                            // .padding(1.dp)
                            .weight(2f),
                        text = medicineModel.medname,
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                        // Begrænser teksten til max én linje
                        // maxLines = 1,
                        // Hvis man skriver mere end én linje, laver den "..."
                        overflow = TextOverflow.Ellipsis

                    )




                }





        }
        Column(horizontalAlignment = Alignment.End){
            Text(text = convTime.toString(),
                style = MaterialTheme.typography.titleMedium,
                // fontWeight = FontWeight.Bold,
                // Begrænser teksten til max én linje
                // maxLines = 1,
                // Hvis man skriver mere end én linje, laver den "..."
                overflow = TextOverflow.Ellipsis

            )
        }
        }
        Box(
            modifier = Modifier
                .padding(20.dp),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    modifier = Modifier
                        // .padding(1.dp)
                        .weight(6f),
                    text = medicineModel.meddose,
                    style = MaterialTheme.typography.titleMedium,
                    // fontWeight = FontWeight.Bold,
                    // Begrænser teksten til max én linje
                    // maxLines = 1,
                    // Hvis man skriver mere end én linje, laver den "..."
                    overflow = TextOverflow.Ellipsis

                )
                IconButton(
                    modifier = Modifier
                        .alpha(ContentAlpha.medium)
                        .weight(1f)
                        .rotate(rotationState),
                    onClick = {
                        expandedState = !expandedState
                    }) {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Drop-Down Arrow"
                    )
                }
            }
        }
        if (expandedState) {
            Text(
                modifier = Modifier
                    .padding(horizontal = 12.dp, vertical = 2.dp),
                text = "Administrationsvej: " + medicineModel.medadm,
                fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                fontWeight = FontWeight.Normal,
                maxLines = 4,
                overflow = TextOverflow.Ellipsis
            )
        }

    }

}

/* @ExperimentalMaterial3Api
@Composable
@Preview
fun MedicineCardPreview(){
    MedicineCard()
}
*/