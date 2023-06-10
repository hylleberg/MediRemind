package com.example.mediremind.ui.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun HomeScreen(viewModel: HomeScreenViewModel = hiltViewModel()) {

    val homeState = viewModel.state.collectAsState().value


    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = homeState.counter.toString(),
            modifier = androidx.compose.ui.Modifier
                .padding(2.dp)
                .wrapContentSize()
                .clickable {
                    viewModel.onCounterClicked()

                }
        )
        Text(
            text = homeState.title,
            modifier = androidx.compose.ui.Modifier
                .padding(2.dp)
                .wrapContentSize()
                .clickable {
                    viewModel.onTitleClicked()

                }
        )


    }

}

@Preview
@Composable
fun HomeScreenPreview() {
    Text(
        text = "Home screen!",
        modifier = Modifier
            .padding(2.dp)
            .fillMaxSize()
            .wrapContentSize()
    )

}