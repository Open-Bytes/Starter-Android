package com.app.albums.screen.home

import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.app.presentation.activity.screen.AppScreen

class HomeScreen(
    override val activity: ComponentActivity,
    override val navController: NavHostController,
) : AppScreen<HomeVM> {

    override val vm: HomeVM by activity.viewModels()

    @Composable
    override fun Content() {
        Text(text = "Hello Home Screen: ${vm.testState.value}")
    }

}