package com.example.mediremind

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mediremind.theme.components.MediRemindScaffold
import com.example.mediremind.ui.theme.MediRemindTheme



@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MediRemindApp() {

    MediRemindTheme() {

        MediRemindScaffold(
            topBar = { TopAppBar(
                title = { Text("Ledige beboere", fontSize = 30.sp, fontWeight = FontWeight.W700, modifier = Modifier.padding(10.dp), color = Color.White) }, colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary))
            },
            floatingActionButtonPosition = FabPosition.Center,
            floatingActionButton = { ExtendedFloatingActionButton(
                onClick = { /* do something */ },
                icon = { Icon(Icons.Filled.CheckCircle, "placeholder", Modifier, Color.Green) },
                text = { Text(text = "Bekræft valg") },
                containerColor = MaterialTheme.colorScheme.primary,
            ) },


            bottomBar = {},
            content = { Text(text = "hej")},
        )
    }
}


        

