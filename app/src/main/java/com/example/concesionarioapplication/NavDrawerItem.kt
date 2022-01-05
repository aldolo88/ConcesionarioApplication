package com.example.concesionarioapplication

sealed class NavDrawerItem(var route:String, var icon:Int, var title:String){
    object Home : NavDrawerItem("home", R.drawable.ic_home,"Home")
    object Employees : NavDrawerItem("employees", R.drawable.ic_employees,"Employees")
    object Others : NavDrawerItem("others", R.drawable.ic_others,"Others")
}
