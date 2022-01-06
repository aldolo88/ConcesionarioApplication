package com.example.concesionarioapplication

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EmployeesListViewModel @Inject constructor(
    private val repository: EmployeeRepository
) :ViewModel() {
    var employeesList = mutableStateOf<List<EmployeesListEntry>>(listOf())
    var loadError = mutableStateOf("")

    fun loadEmployees(){
        viewModelScope.launch {
            val result=repository.getEmployeeList()
            when (result) {
                is Resource.Success -> {
                    val employeesEntries = result.data.
                    EmployeesListEntry()
                }
                is Resource.Error ->{

                }
            }
        }
    }
}