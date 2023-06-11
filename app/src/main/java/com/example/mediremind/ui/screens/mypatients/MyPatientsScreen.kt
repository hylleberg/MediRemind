package com.example.mediremind.ui.screens.mypatients

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mediremind.data.mockdata.testDataList
import com.example.mediremind.ui.components.MyPatientsCard

@Composable
fun MyPatientsScreen() {

    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(16.dp)
    ) {
        item {
            Row(
                modifier = Modifier.fillMaxWidth()
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
        items(testDataList) { testDataItem ->
            MyPatientsCard(testDataItem.name, testDataItem.age)

        }
    }


}
