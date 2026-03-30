package com.example.matule_2026.Presentation.navigate

import androidx.compose.runtime.Composable
import androidx.navigation.activity
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.developmentandtesting.Screen.ProgramScreen
import com.example.developmentandtesting.Screen.SplashScreenCustom

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavigationRoutes.SPLASH) {

        composable(NavigationRoutes.SPLASH){
            SplashScreenCustom(navController)
        }
        composable(NavigationRoutes.MAIN){
            ProgramScreen()
        }

    }
}