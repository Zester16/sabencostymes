package com.example.sabencostimes.schema

import com.example.sabencostimes.R
import com.example.sabencostimes.navigation.NavigationConstant

sealed class BottomNavigationItem(var route:String,var icon:Int,var title:String,) {
object Dash:BottomNavigationItem(NavigationConstant.DASHBOARD, R.drawable.baseline_dashboard_24,"Dashboard")
    object News:BottomNavigationItem(NavigationConstant.TAB_VIEW,R.drawable.baseline_newspaper_24,"News")
}