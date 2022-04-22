package com.example.concesionarioapplication

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/**
 * Used to communicate between screens.
 */
class MainViewModel : ViewModel() {

    private val _currentScreen = MutableLiveData<Screens>(Screens.DrawerScreens.Home)
    val currentScreen: LiveData<Screens> = _currentScreen

    init{

    }

    fun setCurrentScreen(screen: Screens) {
        _currentScreen.value = screen
    }

    //Revisar mutablestateflows
    private val _employeeListResponse = MutableStateFlow<List<Employee>>(emptyList())
    val employeeListResponse : StateFlow<List<Employee>>
        get() = _employeeListResponse
    var errorMessage: String by mutableStateOf("")
    fun getEmployeeList() {
        viewModelScope.launch {
            val apiService = ApiService.getInstance()
            try {
                val employeeList = apiService.getEmployees()
                _employeeListResponse.value = employeeList
            }
            catch (e: Exception) {
                errorMessage = e.message.toString()
                println(errorMessage)
            }
        }
    }
}