package com.example.mediremind.ui.screens.patientlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mediremind.data.model.PatientDataDB
import com.example.mediremind.data.repo.PatientRepository
import com.example.mediremind.ui.screens.patientlist.model.PatientListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PatientListViewModel @Inject constructor(val repository: PatientRepository) : ViewModel() {
    //gammel:
    // private val _state = MutableStateFlow<PatientListState>(PatientListState())
    // ny:
    private val _state = MutableStateFlow<PatientListState>(PatientListState.Loading)
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            repository.getPatients() {
                _state.value = PatientListState.Success(it)
            }
        }
    }

    fun onCardClick(identifier: Int) {

        _state.update { currentState ->
            if (currentState is PatientListState.Success) {
                val tempList = currentState.patientList.map {
                    if (identifier == it.identifier) {
                        it.copy(selected = !it.selected)
                    } else it
                }
                currentState.copy(patientList = tempList)

            } else {
                currentState
            }

        }
    }

    fun getDataFromRepository() {
        //  repository.getPatients();

    }


}