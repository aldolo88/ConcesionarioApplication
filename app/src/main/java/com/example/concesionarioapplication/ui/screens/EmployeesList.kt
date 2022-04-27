package com.example.concesionarioapplication.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.concesionarioapplication.Employee
import com.example.concesionarioapplication.MainViewModel

@Composable
fun RowScope.EmployeeRowTitle(
    title1: String,
    title2: String,
    title3: String,
    weight: Float
) {
    Text(
        text = title1,
        style = MaterialTheme.typography.subtitle1,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .weight(weight)
            .padding(8.dp)
            .fillMaxHeight()
    )
    Text(
        text = title2,
        style = MaterialTheme.typography.subtitle1,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .weight(weight)
            .padding(8.dp)
            .fillMaxHeight()
    )
    Text(
        text = title3,
        style = MaterialTheme.typography.subtitle1,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .weight(weight)
            .padding(8.dp)
            .fillMaxHeight()
    )
}

@Composable
fun RowScope.EmployeeRowText(
    employeeId: Long,
    employeeName: String,
    employeeRole: String,
    weight: Float
) {
    Text(
        text = employeeName,
        style = MaterialTheme.typography.subtitle1,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .weight(weight)
            .padding(8.dp)
            .fillMaxHeight()
    )
    Text(
        text = employeeRole,
        style = MaterialTheme.typography.subtitle1,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .weight(weight)
            .padding(8.dp)
            .fillMaxHeight()
    )
    Text(
        text = employeeName,
        style = MaterialTheme.typography.subtitle1,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .weight(weight)
            .padding(8.dp)
            .fillMaxHeight()
    )
    Text(
        text = "Eliminar",
        style = MaterialTheme.typography.subtitle1,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .weight(weight)
            .padding(8.dp)
            .fillMaxHeight()
    )
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
                EmployeeRowText(employee.id, employee.name, employee.role, 1f)
            }
        }
    }
}

@Composable
fun EmployeeList(employeeList: List<Employee>) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier= Modifier
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
            EmployeeRowTitle("Nombre", "Rol", "Eliminar", 1f)
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
    viewModel.setCurrentScreen(Screens.DrawerScreens.Employees)
    LaunchedEffect(Unit) {
        viewModel.getEmployeeList()
    }
    val employeeList by viewModel.employeeListResponse.collectAsState()
    EmployeeList(employeeList = employeeList)
//Wrapper Response - Resource
}