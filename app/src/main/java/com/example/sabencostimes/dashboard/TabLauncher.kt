package com.example.sabencostimes.dashboard

//import androidx.compose.foundation.ExperimentalFoundationApi
//import androidx.compose.foundation.pager.HorizontalPager
//import androidx.compose.foundation.pager.PagerState
//import androidx.compose.foundation.pager.rememberPagerState
//import androidx.compose.runtime.Composable
//import androidx.navigation.NavHostController
//import com.example.sabencostimes.appTab.NewsTabLayout
//import com.example.sabencostimes.settings.SettingsLayout


//@OptIn(ExperimentalFoundationApi::class)
//@Composable
//fun TabLauncher(index:Int,navHostController: NavHostController){
//val pagerState=rememberPagerState { index }
//    HorizontalPager(state = pagerState) {index->
//
//        when(index){
//            0 -> { DashboardLayout(navHostController = navHostController)}
//            1-> {
//                NewsTabLayout(navHostController = navHostController)
//        }
//            2-> {
//                SettingsLayout()
//            }
//        }
//    }
//}