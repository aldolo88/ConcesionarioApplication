package com.example.concesionarioapplication.data.remote

import com.example.concesionarioapplication.data.remote.responses.EmployeesList
import retrofit2.http.GET

interface EmployeesApi {

    @GET("http://192.168.1.130:8080/employees")
    suspend fun getEmployeesList(

    ): EmployeesList
 }