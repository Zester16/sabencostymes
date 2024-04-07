package com.example.sabencostimes.view

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.sabencostimes.domain.NYTNewsDataDomain
import com.example.sabencostimes.viewmodel.NewsDashModelFactory
import com.example.sabencostimes.viewmodel.NewsDashViewModel

@Composable
fun NewsListView(navHostController: NavHostController, type:Int, viewmodel: NewsDashViewModel =viewModel(factory =NewsDashModelFactory(type))) {

    //val viewmodel = MainDashViewModel()
    val newsList by viewmodel.newsList.observeAsState(emptyList<NYTNewsDataDomain>())
    Column(){
        NewsListColumn(navHost = navHostController, newsList = newsList)
    }

}