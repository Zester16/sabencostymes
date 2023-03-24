package com.example.sabencostimes.view

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavHostController
import com.example.sabencostimes.domain.NYTNewsDataDomain
import com.example.sabencostimes.viewmodel.MainDashViewModel

@Composable
fun NewsListView(navHostController: NavHostController, viewmodel: MainDashViewModel) {

    //val viewmodel = MainDashViewModel()
    val newsList by viewmodel.newsList.observeAsState(emptyList<NYTNewsDataDomain>())
    Column(){
        Text(text = "Business News")
        NewsListColumn(navHost = navHostController, newsList = newsList)
    }

}