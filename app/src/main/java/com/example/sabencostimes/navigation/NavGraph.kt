package com.example.sabencostimes.navigation

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi

import androidx.compose.runtime.Composable

import androidx.navigation.NavHostController

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import com.example.sabencostimes.parceable.NYTNewsParceable

import com.example.sabencostimes.dashboard.DashboardLayout
import com.example.sabencostimes.view.NewsIndividualView
import com.example.sabencostimes.view.NewsListView
import com.example.sabencostimes.appTab.NewsTabLayout
import com.example.sabencostimes.network.xml.parser.Connect
import com.example.sabencostimes.newsLetter.NewsLetterDashboardView
import com.example.sabencostimes.newsLetter.NewsletterView
import com.example.sabencostimes.repository.NYTNewsLetterRepository
import com.example.sabencostimes.webview.NewsWebView
import com.example.sabencostimes.settings.SettingsLayout
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("SuspiciousIndentation")
@Composable
fun NavGraph(navController:NavHostController) {
    //val viewmodel = MainDashViewModel()
    //val newsList by viewmodel.newsList.observeAsState(emptyList<NYTNewsDataDomain>())
    NavHost(navController = navController, startDestination = NavigationConstant.DASHBOARD)
    {

        composable(NavigationConstant.DASHBOARD){
            DashboardLayout(navController)
        }
        composable(NavigationConstant.SETTINGS){
            SettingsLayout()
        }
        composable(NavigationConstant.TAB_VIEW){
            NewsTabLayout(navHostController = navController)
        }
        //shows all news
        composable(NavigationConstant.BUSINESS_NEWS){backStackEntry->

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
        //dashboard for Newsletters
        composable(NavigationConstant.NEWSLETTER_DASH){
            backStackEntry-> NewsLetterDashboardView(navHostController = navController)

        }
        //individual newsletter array
        composable(NavigationConstant.NEWSLETTER_LIST){navBackStackEntry ->
            val newsId = navBackStackEntry.arguments?.getString("news_id")
            if (newsId != null) {
                NewsletterView(navController,respository = NYTNewsLetterRepository(Connect()),newsId)
            }
        }
    }
    

}

