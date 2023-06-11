package com.example.mediremind.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun MyPatientsCard(name: String, age: Int){

    Card(colors = CardDefaults.cardColors()) {
        Column() {
            Row() {
                Text(
                    text = name
                )
            }
            Row() {
                Text(
                    text = age.toString()
                )

            }

        }


    }

}