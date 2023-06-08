package com.example.mediremind

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.mediremind.ui.screens.home.HomeScreen
import com.example.mediremind.ui.screens.patientlist.PatientListScreen

interface MediRemindDestination {
    val icon: ImageVector
    val route: String
    val screen: @Composable () -> Unit

}

object Home : MediRemindDestination {
    override val icon = Icons.Filled.Home
    override val route = "home"
    override val screen: @Composable () -> Unit = { HomeScreen() }

}

object PatientList : MediRemindDestination {
    override val icon = Icons.Filled.Person
    override val route = "plist"
    override val screen: @Composable () -> Unit = { PatientListScreen() }

}

/*object Settings : MediRemindDestination {
    override val icon = Icons.Filled.Settings
    override val route = "settings"
    override val screen: @Composable () -> Unit = { SettingsScreen() }

}*/

val tabRowScreens = listOf(Home, PatientList)