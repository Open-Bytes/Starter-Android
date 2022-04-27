package com.app.presentation.activity.screen

import androidx.activity.ComponentActivity
import androidx.navigation.NavHostController

interface ScreenHost {

    val activity: ComponentActivity
    val navController: NavHostController

    fun navigate(route: String) {
        navController.navigate(route)
    }

    fun popBackStack() {
        navController.popBackStack()
    }
}