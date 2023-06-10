package com.example.mediremind.ui.screens.patientlist

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.example.mediremind.ui.screens.home.model.HomeScreenState
import com.example.mediremind.ui.screens.patientlist.model.PatientListState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

class PatientListViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow<PatientListState>(PatientListState())
    val state = _state.asStateFlow()

    fun selectCard(){
        _state.update{ currentState ->

            val nextState = currentState.copy(selected = true, color = Color(0xFFB7D167))
            nextState
        }
    }

    fun unselectCard(){
        _state.update{ currentState ->

            val nextState = currentState.copy(selected = false, color = Color(0xFFD2EE80))
            nextState
        }
    }


}