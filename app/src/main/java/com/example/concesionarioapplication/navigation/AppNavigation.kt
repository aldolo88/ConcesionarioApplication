package com.example.concesionarioapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.concesionarioapplication.*
import com.example.concesionarioapplication.ui.screens.*

@Composable
fun NavigationHost(navController: NavController, viewModel: MainViewModel) {
    NavHost(
        navController = navController as NavHostController,
        startDestination = Screens.DrawerScreens.Home.route
    ) {
        composable(Screens.DrawerScreens.Home.route) { Home(viewModel = viewModel) }
        composable(Screens.DrawerScreens.Account.route) { Account(viewModel = viewModel) }
        composable(Screens.DrawerScreens.Help.route) { Help(viewModel = viewModel) }
        composable(Screens.DrawerScreens.Employees.route) { Employees(viewModel = viewModel) }
    }
    //ver funciones lambda para poder navegar entre pantallas a futuro
}