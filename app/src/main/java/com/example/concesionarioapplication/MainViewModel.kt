package com.example.concesionarioapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Used to communicate between screens.
 */
class MainViewModel : ViewModel() {

    private val _currentScreen = MutableLiveData<Screens>(Screens.DrawerScreens.Home)
    val currentScreen: LiveData<Screens> = _currentScreen

    fun setCurrentScreen(screen: Screens) {
        _currentScreen.value = screen
    }
}