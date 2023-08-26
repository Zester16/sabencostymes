package com.example.sabencostimes.navigation

import android.annotation.SuppressLint

import androidx.compose.runtime.Composable

import androidx.navigation.NavHostController

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import com.example.sabencostimes.parceable.NYTNewsParceable

import com.example.sabencostimes.view.DashboardLayout
import com.example.sabencostimes.view.NewsIndividualView
import com.example.sabencostimes.view.NewsListView
import com.example.sabencostimes.view.NewsTabLayout
import com.example.sabencostimes.view.NewsWebView
import com.example.sabencostimes.view.SettingsLayout
import com.example.sabencostimes.viewmodel.NewsDashViewModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

@SuppressLint("SuspiciousIndentation")
@Composable
fun NavGraph(navController:NavHostController) {
    //val viewmodel = MainDashViewModel()
    //val newsList by viewmodel.newsList.observeAsState(emptyList<NYTNewsDataDomain>())
    NavHost(navController = navController, startDestination = NavigationConstant.DASHBOARD)
    {

        composable(NavigationConstant.DASHBOARD){
            DashboardLayout()
        }
        composable(NavigationConstant.SETTINGS){
            SettingsLayout()
        }
        composable(NavigationConstant.TAB_VIEW){
            NewsTabLayout(navHostController = navController)
        }
        //shows all news
        composable(NavigationConstant.BUSINESS_NEWS){

            NewsListView(navHostController = navController,1)
            
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

