package com.example.mediremind

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons

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
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mediremind.model.NavigationItem
import com.example.mediremind.theme.components.MediRemindScaffold
import com.example.mediremind.ui.components.MediRemindNavBar
import com.example.mediremind.ui.components.MediRemindTopBar
import com.example.mediremind.ui.components.Navigation
import com.example.mediremind.ui.screens.home.HomeScreen
import com.example.mediremind.ui.screens.patientlist.PatientListScreen
import com.example.mediremind.ui.theme.MediRemindTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MediRemindApp() {


    MediRemindTheme() {
        val navController = rememberNavController()
        MediRemindScaffold(
            topBar = {
                MediRemindTopBar(
                    title = {
                        Text("MediRemind Home")
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


            bottomBar = { MediRemindNavBar(navController) },
            content = { innerPadding ->
                Box(modifier = Modifier.padding(20.dp)) {
                    Navigation(navController = navController)
                }
            }

        )
    }
}





