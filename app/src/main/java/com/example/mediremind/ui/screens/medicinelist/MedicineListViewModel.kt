package com.example.mediremind.ui.screens.medicinelist

import androidx.lifecycle.ViewModel
import com.example.mediremind.data.repo.PatientRepository
import com.example.mediremind.ui.screens.medicinelist.model.MedicineListState
import com.example.mediremind.ui.screens.patientlist.model.PatientListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MedicineListViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow<MedicineListState>(MedicineListState())
    val state = _state.asStateFlow()

    /* fun onCardClick(identifier: Int){

        _state.update{ currentState ->
            val tempList = currentState.mList.map {
                if(identifier == it.identifier){
                    it.copy(selected = !it.selected)
                }else it
            }
            currentState.copy(mList = tempList)
        }
    }

    fun getDataFromRepository(){
        repository.getPatients();

    }
*/

}
