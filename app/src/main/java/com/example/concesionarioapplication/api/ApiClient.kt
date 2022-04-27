package com.example.concesionarioapplication.api

import com.example.concesionarioapplication.Employee
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface ApiClient {
    @GET("employees") fun getEmployeesAsync(): Deferred<Response<List<Employee>>>
}