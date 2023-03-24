package com.example.sabencostimes.navigation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.sabencostimes.domain.NYTNewsDataDomain
import com.example.sabencostimes.parceable.NYTNewsParceable
import com.example.sabencostimes.view.NewsIndividualView
import com.example.sabencostimes.view.NewsListView
import com.example.sabencostimes.view.NewsWebView
import com.example.sabencostimes.viewmodel.MainDashViewModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

@SuppressLint("SuspiciousIndentation")
@Composable
fun NavGraph(navController:NavHostController) {
    val viewmodel = MainDashViewModel()
    val newsList by viewmodel.newsList.observeAsState(emptyList<NYTNewsDataDomain>())
    NavHost(navController = navController, startDestination = NavigationConstant.BUSINESS_NEWS)
    {
        //shows all news
        composable(NavigationConstant.BUSINESS_NEWS){

            NewsListView(navHostController = navController,viewmodel)
            
        }
        //show individual news
        composable(NavigationConstant.INDIVIDUAL_NEWS){backStackEntry->
            val newsJson =  backStackEntry.arguments?.getString("news")
            val moshi = Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()
            val jsonAdapter = moshi.adapter(NYTNewsParceable::class.java).lenient()
            val news = jsonAdapter.fromJson(newsJson)

                NewsIndividualView(news = news!!, navController = navController)
            }
        composable(NavigationConstant.WEB_VIEW_PATH){ backStackEntry->
            val urlLink = backStackEntry.arguments?.getString("webUrl")
            if (urlLink != null) {
                NewsWebView(navController = navController,newsUrl= urlLink)
            }
        }
    }
    

}

