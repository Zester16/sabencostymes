package com.example.sabencostimes.view

import androidx.compose.runtime.Composable
import androidx.compose.material.Text
import androidx.navigation.NavHostController
import com.example.sabencostimes.domain.NYTNewsDataDomain
import com.example.sabencostimes.parceable.NYTNewsParceable

@Composable
fun NewsIndividualView(navController:NavHostController,news:NYTNewsParceable) {
    Text("This is Individual News")

    news?.title?.let { Text(it) }
}