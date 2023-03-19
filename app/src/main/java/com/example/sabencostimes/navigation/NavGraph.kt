package com.example.sabencostimes.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.sabencostimes.view.NewsListView

@Composable
fun NavGraph(navController:NavHostController) {
    NavHost(navController = navController, startDestination = NavigationConstant.BUSINESS_NEWS)
    {
        composable(NavigationConstant.BUSINESS_NEWS){
            NewsListView(navHostController = navController)
            
        }
    }
    

}