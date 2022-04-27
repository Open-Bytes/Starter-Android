package com.app.albums.activity

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.app.albums.navhost.AppNavHost
import com.app.presentation.activity.AppComposeActivity

class MainActivity : AppComposeActivity() {

    @Composable
    override fun Content() {
        val navController = rememberNavController()
        AppNavHost(this, navController).Setup()
    }
}
