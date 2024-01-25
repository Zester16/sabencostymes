package com.example.sabencostimes.schema

import com.example.sabencostimes.R
import com.example.sabencostimes.navigation.NavigationConstant

sealed class BottomNavigationItem(var route:String,var icon:Int,var title:String,) {
object Dash:BottomNavigationItem(NavigationConstant.DASHBOARD, R.drawable.baseline_dashboard_24,"Dashboard")
    object News:BottomNavigationItem(NavigationConstant.TAB_VIEW,R.drawable.baseline_newspaper_24,"News")
object Newsletter:BottomNavigationItem(NavigationConstant.BUSINESS_NEWS,R.drawable.baseline_newsletter_stories_24,"test")
//object Market
//object Search
object Settings: BottomNavigationItem(NavigationConstant.SETTINGS,R.drawable.more_black_24,"Settings")

}