package com.example.concesionarioapplication

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

/**
 * Used to communicate between screens.
 */
class MainViewModel : ViewModel() {

    private val _currentScreen = MutableLiveData<Screens>(Screens.DrawerScreens.Home)
    val currentScreen: LiveData<Screens> = _currentScreen

    fun setCurrentScreen(screen: Screens) {
        _currentScreen.value = screen
    }

    var employeeListResponse:List<Employee> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")
    fun getEmployeeList() {
        viewModelScope.launch {
            val apiService = ApiService.getInstance()
            try {
                val employeeList = apiService.getEmployees()
                employeeListResponse = employeeList
            }
            catch (e: Exception) {
                errorMessage = e.message.toString()
                println(errorMessage)
            }
        }
    }
}