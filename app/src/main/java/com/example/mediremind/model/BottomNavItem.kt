package com.example.mediremind.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.ui.graphics.vector.ImageVector

class BottomNavItem(

    val name: String,
    val route: String,
    val icon: ImageVector,
)
val bottomNavItems = listOf(
    BottomNavItem(
        name = "Hjem",
        route = "home",
        icon = Icons.Filled.Home,
    ),
    BottomNavItem(
        name = "Patientliste",
        route = "list",
        icon = Icons.Filled.List,
    ),
    BottomNavItem(
        name = "Indstillinger",
        route = "settings",
        icon = Icons.Filled.Settings,
    ),
)