package com.example.mediremind.ui.screens.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(){

    Text(
        text = "Home screen",
        modifier = androidx.compose.ui.Modifier
            .padding(2.dp)
            .fillMaxSize()
            .wrapContentSize()
    )
}

@Preview
@Composable
fun HomeScreenPreview(){
    Text(
        text = "Home screen!",
        modifier = Modifier
            .padding(2.dp)
            .fillMaxSize()
            .wrapContentSize()
    )

}