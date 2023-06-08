package com.example.mediremind.model

import android.graphics.drawable.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationItem(var route: String, val icon: ImageVector, var title: String) {
    object Home : NavigationItem("home", Icons.Filled.Home, "Hjem")
    object PatientList : NavigationItem("music", Icons.Filled.Person, "Patient liste")}
