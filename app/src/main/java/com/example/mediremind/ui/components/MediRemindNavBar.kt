package com.example.mediremind.ui.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.mediremind.data.model.NavigationItem
import com.example.mediremind.ui.screens.home.HomeScreen
import com.example.mediremind.ui.screens.mypatients.MyPatientsScreen
import com.example.mediremind.ui.screens.patientlist.PatientListScreen

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun MediRemindNavBar(navController: NavController) {
    val items = listOf(
        NavigationItem.Home,
        NavigationItem.PatientList,
        NavigationItem.MyPatients,

        )
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = Color.White
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = "${item.title} Icon",
                        Modifier,
                        Color.Black
                    )
                },
                label = { Text(text = item.title) },
                alwaysShowLabel = true,
                selected = currentRoute == item.route,

                onClick = {

                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                               saveState = true
                            }
                        }

                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = NavigationItem.Home.route) {
        composable(NavigationItem.Home.route) {
            HomeScreen()
        }
        composable(NavigationItem.PatientList.route) {
            PatientListScreen()
        }
        composable(NavigationItem.MyPatients.route) {
            MyPatientsScreen()
        }
    }
}