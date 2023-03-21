package com.example.sabencostimes.navigation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.sabencostimes.parceable.NYTNewsParceable
import com.example.sabencostimes.view.NewsIndividualView
import com.example.sabencostimes.view.NewsListView
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

@SuppressLint("SuspiciousIndentation")
@Composable
fun NavGraph(navController:NavHostController) {
    NavHost(navController = navController, startDestination = NavigationConstant.BUSINESS_NEWS)
    {
        composable(NavigationConstant.BUSINESS_NEWS){
            NewsListView(navHostController = navController)
            
        }
        composable(NavigationConstant.INDIVIDUAL_NEWS){backStackEntry->
            val newsJson =  backStackEntry.arguments?.getString("news")
            val moshi = Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()
            val jsonAdapter = moshi.adapter(NYTNewsParceable::class.java).lenient()
            val news = jsonAdapter.fromJson(newsJson)

                NewsIndividualView(news = news!!, navController = navController)
            }


    }
    

}

