package com.example.concesionarioapplication

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

sealed class Screens(val route: String, val title: String) {

    sealed class DrawerScreens(
        route: String,
        title: String
    ) : Screens(route, title) {
        object Home : DrawerScreens("home", "Home")
        object Account : DrawerScreens("account", "Account")
        object Help : DrawerScreens("help", "Help")
        object Employees : DrawerScreens("employees", "Employees")
    }
}

val screensFromDrawer = listOf(
    Screens.DrawerScreens.Home,
    Screens.DrawerScreens.Account,
    Screens.DrawerScreens.Help,
    Screens.DrawerScreens.Employees,
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

@Composable
fun EmployeeItem(employee: Employee) {
    Card(
        modifier = Modifier
            .padding(8.dp, 4.dp)
            .fillMaxWidth()
            .height(50.dp), shape = RoundedCornerShape(8.dp), elevation = 4.dp
    ) {
        Surface() {
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxSize()
            ) {
                TableCell(employee.name, 1f)
                TableCell(employee.role, 1f)
            }
        }
    }
}

@Composable
fun EmployeeList(employeeList: List<Employee>) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier=Modifier
            .fillMaxSize()
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .weight(0.1f)
                .padding(4.dp)
                .fillMaxWidth(0.8f)
                .border(border= BorderStroke(1.dp, Color.Black))
        ) {
            TableCell("Nombre", 1F)
            TableCell("Rol", 1F)
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .weight(0.9f)
                .padding(4.dp)
                .fillMaxWidth()
        ) {
            LazyColumn {
                itemsIndexed(items = employeeList) { index, item ->
                    EmployeeItem(employee = item)
                }
            }
        }
    }
}

@Composable
fun Employees(viewModel: MainViewModel) {
    LaunchedEffect(Unit){
        viewModel.getEmployeeList()
        viewModel.setCurrentScreen(Screens.DrawerScreens.Employees)
    }
    val employeeList by viewModel.employeeListResponse.collectAsState()
    EmployeeList(employeeList = employeeList)
    //Wrapper Response - Resource
}