package com.example.concesionarioapplication

import com.squareup.moshi.Json

data class Employee(
    @field:Json(name="id") val id:Long,
    @field:Json(name="name") val name:String,
    @field:Json(name="role") val role:String
    )