package com.example.mediremind.ui.screens.patientlist

import androidx.lifecycle.ViewModel
import com.example.mediremind.data.repo.PatientRepository
import com.example.mediremind.ui.screens.patientlist.model.PatientListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class PatientListViewModel @Inject constructor(val repository: PatientRepository) : ViewModel() {

     private val _state = MutableStateFlow<PatientListState>(PatientListState())
     val state = _state.asStateFlow()

    fun onCardClick(identifier: Int){

        _state.update{ currentState ->
            val tempList = currentState.pList.map {
                if(identifier == it.identifier){
                    it.copy(selected = !it.selected)
                }else it
            }
            currentState.copy(pList = tempList)
        }
    }


}