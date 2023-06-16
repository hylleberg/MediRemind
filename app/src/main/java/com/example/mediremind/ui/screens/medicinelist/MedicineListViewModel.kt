package com.example.mediremind.ui.screens.medicinelist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mediremind.data.repo.PatientRepository
import com.example.mediremind.ui.screens.medicinelist.model.MedicineListState
import com.example.mediremind.ui.screens.mypatients.model.MyPatientsScreenState
import com.example.mediremind.ui.screens.patientlist.model.PatientListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MedicineListViewModel @Inject constructor(val repository: PatientRepository) : ViewModel() {

    private val _state = MutableStateFlow<MedicineListState>(MedicineListState.Loading)
    val state = _state.asStateFlow()


    fun fetchMedicine(id: String) {
        viewModelScope.launch {
            _state.value = MedicineListState.Loading
            delay(200)

                _state.value = MedicineListState.Success(repository.getMedicineCollection(id))

        }


        }
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

