package com.example.mediremind

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mediremind.model.BottomNavItem
import com.example.mediremind.model.bottomNavItems
import com.example.mediremind.theme.components.MediRemindScaffold
import com.example.mediremind.ui.components.MediRemindTopBar
import com.example.mediremind.ui.screens.patientlist.PatientListScreen
import com.example.mediremind.ui.theme.MediRemindTheme



@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun MediRemindApp() {

    MediRemindTheme() {
        MediRemindScaffold(
            topBar = {
                     MediRemindTopBar(
                         title = {
                                 Text("Mediremind Home")
                         },
                         navigationIcon = {
                             IconButton(onClick = { /* doSomething() */ }) {
                                 Icon(
                                     imageVector = Icons.Filled.Home,
                                     contentDescription = "Localized description"
                                 )
                             }
                         },
                     )

            },
/*            floatingActionButtonPosition = FabPosition.Center,
            floatingActionButton = { ExtendedFloatingActionButton(
                onClick = { /* do something */ },
                icon = { Icon(Icons.Filled.CheckCircle, "placeholder", Modifier, Color.Green) },
                text = { Text(text = "Bekræft valg") },
                containerColor = MaterialTheme.colorScheme.primary,
            ) },*/


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

            }}},
            content = {
                      PatientListScreen()
            },
            )}}

@Composable
fun Test(){

        Text(text = "test test")

}

        

