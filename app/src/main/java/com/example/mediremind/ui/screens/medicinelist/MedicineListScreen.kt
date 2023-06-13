package com.example.mediremind.ui.screens.medicinelist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.mediremind.data.mockdata.MedicineData
import com.example.mediremind.data.model.NavigationItem
import com.example.mediremind.ui.components.MedicineCard


@Composable

fun MedicineListScreen (navController: NavController, viewModel: MedicineListViewModel = hiltViewModel()) {
    // Composable, der emitter til UI
    // Kalder til nogle View-model metoder, der hiver data fra en model
    val medicineListState = viewModel.state.collectAsState().value
    var context = LocalContext.current


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
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button( modifier= Modifier
                    .weight(2f),
                    onClick = { navController.navigate(NavigationItem.MyPatients.route) },
                    // Uses ButtonDefaults.ContentPadding by default
                    contentPadding = PaddingValues(
                        start = 20.dp,
                        top = 12.dp,
                        end = 20.dp,
                        bottom = 12.dp
                    )
                ) {
                    // Inner content including an icon and a text label
                    Icon(
                        Icons.Filled.KeyboardArrowLeft,
                        contentDescription = "TilbagePatient",
                        modifier = Modifier.size(ButtonDefaults.IconSize)
                    )
                    Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                    //Text("")

                }
                Text( modifier= Modifier
                    .weight(7f)
                    .padding(2.dp),
                    text = "Medicin",
                    style = MaterialTheme.typography.headlineMedium
                )
            }
        }
         items(medicineListState.mList) { medicine ->
            MedicineCard(medicine)
              }
        }
    }

    /* Box(modifier = Modifier.fillMaxSize()) {
         FloatingActionButton(
             modifier = Modifier
                 .padding(all = 16.dp)
                 .align(alignment = Alignment.BottomEnd)
                 .offset(x = -10.dp, y = -70.dp)
     ,
                          onClick = {
                 viewModel.getDataFromRepository()

                 //setAlarm(name = "Hanna", medication = "Kokain" , time = LocalDateTime.now().plusSeconds(5), context)
                 // Toast.makeText(context, "Click", Toast.LENGTH_SHORT)
                 //    .show()

             }
           {


           // Icon(imageVector = Icons.Filled.CheckCircle, contentDescription = "Add")

      }
    }
}
*/

/*
@Preview
@Composable
fun MedicineListScreenPreview(){
    Text(
        text = "Medicine list screen!",
        modifier = Modifier
            .padding(2.dp)
            .fillMaxSize()
            .wrapContentSize()
    )

}
    */
