package com.example.mediremind.ui.screens.mypatients

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mediremind.data.repo.PatientRepository
import com.example.mediremind.ui.screens.mypatients.model.MyPatientsScreenState
import com.example.mediremind.ui.screens.patientlist.DefaultLifecycleObserver
import com.example.mediremind.ui.screens.patientlist.model.PatientListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyPatientsScreenViewModel @Inject constructor(val repository: PatientRepository) : ViewModel(),
    DefaultLifecycleObserver {
    //gammel:
    // private val _state = MutableStateFlow<PatientListState>(PatientListState())
    // ny:
    private val _state = MutableStateFlow<MyPatientsScreenState>(MyPatientsScreenState.Loading)
    val state = _state.asStateFlow()


    fun fetchAssignedPatients() {
        viewModelScope.launch {
            _state.value = MyPatientsScreenState.Loading
            delay(200)
            repository.getSelectedPatients() {
                _state.value = MyPatientsScreenState.Success(it)
            }
        }
    }

    fun unassignPatient(idList: List<String>) {
        repository.unsetSelectedPatient(idList)
        fetchAssignedPatients()
    }


    fun onCardClick(identifier: Int) {

        _state.update { currentState ->
            if (currentState is MyPatientsScreenState.Success) {
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

    }
