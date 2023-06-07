package com.example.mediremindOLD

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    val name: String,
    val route: String,
    val icon: ImageVector,
)

val bottomNavItems = listOf(
    BottomNavItem(
        name = "Hjem",
        route = "home",
        icon = Icons.Rounded.Home,
    ),
    BottomNavItem(
        name = "Ansvar",
        route = "add",
        icon = Icons.Rounded.Person,
    ),
    BottomNavItem(
        name = "Settings",
        route = "settings",
        icon = Icons.Rounded.Settings,
    ),
)