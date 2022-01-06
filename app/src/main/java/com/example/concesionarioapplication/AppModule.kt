package com.example.concesionarioapplication

import com.example.concesionarioapplication.data.remote.EmployeesApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideEmployeesApi(
        api: EmployeesApi
    )=EmployeeRepository(api)

    @Singleton
    @Provides
    fun provideEmployeesApi(): EmployeesApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://192.168.1.130:8080/")
            .build()
            .create(EmployeesApi::class.java)
    }
}
