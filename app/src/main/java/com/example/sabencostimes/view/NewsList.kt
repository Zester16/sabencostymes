package com.example.sabencostimes.view

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.sabencostimes.domain.NYTNewsDataDomain

@Composable
fun NewsListColumn(navHost:NavHostController,newsList:List<NYTNewsDataDomain>){
    LazyColumn() {
        items(items = newsList) {
            NewsCardView(navHost,nytNews = it)
        }
    }
}

