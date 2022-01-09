package com.example.concesionarioapplication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

sealed class Screens(val route: String, val title: String) {

    sealed class DrawerScreens(
        route: String,
        title: String
    ) : Screens(route, title) {
        object Home : DrawerScreens("home", "Home")
        object Account : DrawerScreens("account", "Account")
        object Help : DrawerScreens("help", "Help")
    }
}

val screensFromDrawer = listOf(
    Screens.DrawerScreens.Home,
    Screens.DrawerScreens.Account,
    Screens.DrawerScreens.Help,
)

@Composable
fun Home(modifier: Modifier = Modifier, viewModel: MainViewModel) {
    viewModel.setCurrentScreen(Screens.DrawerScreens.Home)
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Home.", style = MaterialTheme.typography.h4)
    }
}

@Composable
fun Account(modifier: Modifier = Modifier, viewModel: MainViewModel) {
    viewModel.setCurrentScreen(Screens.DrawerScreens.Account)
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Account.", style = MaterialTheme.typography.h4)
    }
}

@Composable
fun Help(modifier: Modifier = Modifier, viewModel: MainViewModel) {
    viewModel.setCurrentScreen(Screens.DrawerScreens.Help)
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Help.", style = MaterialTheme.typography.h4)
    }
}