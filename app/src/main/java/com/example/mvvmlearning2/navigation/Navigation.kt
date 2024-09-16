package com.example.mvvmlearning2.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mvsharedViewModellearning2.screens.DetailScreen
import com.example.mvvmlearning2.screens.MainScreen
import com.example.mvvmlearning2.viewmodels.FruitViewModel

@Composable
fun Navigation(
){

    val sharedViewModel: FruitViewModel = hiltViewModel()

    val navController = rememberNavController();
    NavHost(navController = navController, startDestination = "mainScreen") {

        composable("mainScreen") {
            MainScreen(navController, sharedViewModel)
        }
        composable("detailScreen"){
            DetailScreen(sharedViewModel)
        }

    }
}


