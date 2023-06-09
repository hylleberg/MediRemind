package com.example.mediremind.ui.screens.home

import androidx.lifecycle.ViewModel
import com.example.mediremind.ui.screens.home.model.HomeScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow<HomeScreenState>(HomeScreenState())
    val state = _state.asStateFlow()

    fun onCounterClicked(){

       // _state.value = _state.value.copy(counter = _state.value.counter+1)
        _state.update { currentState ->
            val lastCounterValue = currentState.counter
            val nextCounterValue = lastCounterValue+1

            val nextState = currentState.copy(counter = nextCounterValue)
            nextState
        }
    }

    fun onTitleClicked(){
        _state.update { currentState ->

            val nextState = currentState.copy(title = "Ny test haklkløj")
            nextState

        }

    }



}