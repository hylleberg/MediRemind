package com.example.mediremind.ui.components

import android.util.Log
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.Center
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FractionalThreshold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.rememberSwipeableState
import androidx.compose.material.swipeable
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material3.ContentAlpha
import com.example.mediremind.data.model.MedicineData
import java.time.format.DateTimeFormatter
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun MedicineCard(medicineModel: MedicineData) {
    var expandedState by remember { mutableStateOf(false) }
    val rotationState by animateFloatAsState(
        targetValue = if (expandedState) 180f else 0f
    )

    val dateTimeFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
    val convTime: String = dateTimeFormatter.format(medicineModel.alarmtime)

    var backgroundColor = MaterialTheme.colorScheme.tertiary
    var swipeBgColor = MaterialTheme.colorScheme.tertiaryContainer
    var swipeButtonColor = MaterialTheme.colorScheme.onTertiaryContainer


    val width = 280.dp
    val squareSize = 50.dp

    val swipeableState = rememberSwipeableState(0)
    val sizePx = with(LocalDensity.current) { 230.dp.toPx() }
    val anchors = mapOf(0f to 0, sizePx to 1) // Maps anchor points (in px) to states



    Log.d("swipe", swipeableState.currentValue.toString())

    if (swipeableState.currentValue == 0) {
        backgroundColor = MaterialTheme.colorScheme.tertiary
        swipeBgColor = MaterialTheme.colorScheme.tertiaryContainer
        swipeButtonColor = MaterialTheme.colorScheme.onTertiaryContainer

    } else {
        backgroundColor = Color.LightGray
        swipeBgColor = Color.Gray
        swipeButtonColor = Color.DarkGray

    }


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
        ) {


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
            Column(horizontalAlignment = Alignment.End) {
                Text(
                    text = convTime.toString(),
                    style = MaterialTheme.typography.titleMedium,
                    // fontWeight = FontWeight.Bold,
                    // Begrænser teksten til max én linje
                    // maxLines = 1,
                    // Hvis man skriver mere end én linje, laver den "..."
                    overflow = TextOverflow.Ellipsis

                )
            }


        }
        Row(
            verticalAlignment = Alignment.Top,

            modifier = Modifier
                .padding(20.dp),
        ) {
            Box(
                modifier = Modifier
                    .width(width)
                    .clip(shape = RoundedCornerShape(20.dp))
                    .swipeable(
                        state = swipeableState,
                        anchors = anchors,
                        thresholds = { _, _ -> FractionalThreshold(0.6f) },
                        orientation = Orientation.Horizontal
                    )
                    .background(swipeBgColor),
            ) {
                Box(
                    Modifier
                        .offset { IntOffset(swipeableState.offset.value.roundToInt(), 0) }


                        .clip(shape = RoundedCornerShape(20.dp))
                        .width(50.dp)
                        .size(squareSize / 2)
                        .background(swipeButtonColor)
                        ,

                    ) {

                        Icon(
                            Icons.Filled.KeyboardArrowRight,
                            contentDescription = "swipe",
                            Modifier.align(Alignment.Center)

                            )


                }
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
                // fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                // fontWeight = FontWeight.Normal,
                // maxLines = 4,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                modifier = Modifier
                    .padding(horizontal = 12.dp, vertical = 2.dp),
                text = medicineModel.medexp,
                // fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                // fontWeight = FontWeight.Normal,
                // maxLines = 4,
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