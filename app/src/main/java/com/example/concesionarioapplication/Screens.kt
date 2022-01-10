package com.example.concesionarioapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.concesionarioapplication.ui.theme.JetpackComposeMVVMRetrofitAndRecyclerviewTheme

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
            .height(110.dp), shape = RoundedCornerShape(8.dp), elevation = 4.dp
    ) {
        Surface() {

            Row(
                Modifier
                    .padding(4.dp)
                    .fillMaxSize()
            ) {

                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxHeight()
                        .weight(0.8f)
                ) {

                    Text(
                        text = employee.id.toString(),
                        style = MaterialTheme.typography.caption,
                        modifier = Modifier
                            .background(
                                Color.LightGray
                            )
                            .padding(4.dp)
                    )
                    Text(
                        text = employee.name,
                        style = MaterialTheme.typography.caption,
                        modifier = Modifier
                            .background(
                                Color.LightGray
                            )
                            .padding(4.dp)
                    )
                    Text(
                        text = employee.role,
                        style = MaterialTheme.typography.caption,
                        modifier = Modifier
                            .background(
                                Color.LightGray
                            )
                            .padding(4.dp)
                    )

                }
            }
        }
    }

}

@Composable
fun EmployeeList(employeeList: List<Employee>) {
    LazyColumn {
        itemsIndexed(items = employeeList) { index, item ->
            EmployeeItem(employee=item)
        }
    }
}


@Composable
fun Employees(modifier: Modifier = Modifier, viewModel: MainViewModel, employeeList: List<Employee>) {
    JetpackComposeMVVMRetrofitAndRecyclerviewTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
            EmployeeList(employeeList = employeeList)
        }
    }
    viewModel.setCurrentScreen(Screens.DrawerScreens.Employees)
}