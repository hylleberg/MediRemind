package com.example.mediremind.ui.screens.patientlist

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver

interface DefaultLifecycleObserver {

    @Composable
    fun <LO : LifecycleObserver> LO.observeLifecycle(lifecycle: Lifecycle) {
        DisposableEffect(lifecycle) {
            lifecycle.addObserver(this@observeLifecycle)
            onDispose {
                lifecycle.removeObserver(this@observeLifecycle)
            }
        }
    }
}