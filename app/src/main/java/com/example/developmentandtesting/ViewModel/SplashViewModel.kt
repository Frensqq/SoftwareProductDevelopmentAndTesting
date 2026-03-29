package com.example.developmentandtesting.ViewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.example.matule_2026.Presentation.navigate.NavigationRoutes
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashViewModel(): ViewModel() {

    fun launch(controller: NavHostController){
        viewModelScope.launch {
            delay(2000)
            controller.navigate(NavigationRoutes.MAIN)
        }
    }
}