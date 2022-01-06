package com.example.concesionarioapplication

import com.example.concesionarioapplication.data.remote.EmployeesApi
import com.example.concesionarioapplication.data.remote.responses.EmployeesList
import dagger.hilt.android.scopes.ActivityScoped
import java.lang.Exception
import javax.inject.Inject

@ActivityScoped
class EmployeeRepository @Inject constructor(
    private val api : EmployeesApi
)  {
    suspend fun getEmployeeList(): Resource<EmployeesList>{
        val response=try{
            api.getEmployeesList()
        } catch(e: Exception){
            return Resource.Error("An unexpected error occured.")
        }
        return Resource.Success(response)
    }
}