package com.example.mediremind

import android.annotation.SuppressLint
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mediremind.alarm.AlarmItem
import com.example.mediremind.alarm.AlarmScheduler
import com.example.mediremind.alarm.AlarmSchedulerImpl
import com.example.mediremind.model.NavigationItem
import com.example.mediremind.theme.components.MediRemindScaffold
import com.example.mediremind.ui.components.MediRemindNavBar
import com.example.mediremind.ui.components.MediRemindTopBar
import com.example.mediremind.ui.components.Navigation
import com.example.mediremind.ui.screens.home.HomeScreen
import com.example.mediremind.ui.screens.patientlist.PatientListScreen
import com.example.mediremind.ui.theme.MediRemindTheme
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberPermissionState
import java.time.LocalDateTime
import android.Manifest
import android.content.Context
import android.util.Log
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.result.ActivityResultLauncher
import androidx.compose.runtime.SideEffect


@OptIn(ExperimentalMaterial3Api::class, ExperimentalPermissionsApi::class)
@Composable
fun MediRemindApp() {

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Hardcoded set alarm - needs implemented as automatically set n-alarms for n-medications from n-patients
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    val context = LocalContext.current
    val alarmScheduler: AlarmScheduler = AlarmSchedulerImpl(context)
    var alarmItem: AlarmItem? = null

    alarmItem = AlarmItem(
        alarmTime = LocalDateTime.now().plusSeconds(
            10
        ),
        message = "Ove Sprogdøv skal have sin medicin!"
    )
    alarmItem?.let(alarmScheduler::schedule)

   //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    MediRemindTheme() {
        val navController = rememberNavController()
        MediRemindScaffold(
            topBar = {
                MediRemindTopBar(
                    title = {
                        Text("MediRemind")
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
            /*           ,*/


            bottomBar = { MediRemindNavBar(navController) },
            content = { innerPadding ->
                Box(modifier = Modifier.padding(20.dp)) {
                    Navigation(navController = navController)

                    launcher(context)

                }
            }

        )
    }
}
@Composable
fun launcher(context: Context){

    val launcher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            Log.e("Permission", "Permissions granted!")
        } else {
            Log.e("Permission", "Permissions not granted :(")
        }

    }
    checkAndRequestCameraPermission(context = context, permission = Manifest.permission.POST_NOTIFICATIONS, launcher = launcher)
}

@Composable
fun checkAndRequestCameraPermission(
    context: Context,
    permission: String,
    launcher: ManagedActivityResultLauncher<String, Boolean>
) {
    val permissionCheckResult = ContextCompat.checkSelfPermission(context, permission)
    if (permissionCheckResult == PackageManager.PERMISSION_GRANTED) {
        // do nothing
    } else {
        // Request a permission
        SideEffect {
            launcher.launch(permission)
        }

    }
}


