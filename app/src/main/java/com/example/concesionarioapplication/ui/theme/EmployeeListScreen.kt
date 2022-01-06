package com.example.concesionarioapplication.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.concesionarioapplication.EmployeesListEntry
import com.example.concesionarioapplication.EmployeesListViewModel
import com.example.concesionarioapplication.R
import dagger.hilt.android.internal.lifecycle.HiltViewModelFactory

@Composable
fun EmployeesListScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.design_default_color_primary_dark))
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Employees View",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 25.sp
        )
    }
}

@Composable
fun EmployeeEntry(
    entry:EmployeesListEntry,
    navController: NavController,
    modifier: Modifier=Modifier,
    viewModel: EmployeesListViewModel = hiltViewModel()
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.design_default_color_primary_dark))
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = entry.name,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 25.sp
        )
}