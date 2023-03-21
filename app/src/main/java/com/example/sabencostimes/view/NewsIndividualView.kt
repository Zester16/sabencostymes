package com.example.sabencostimes.view

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.material.Text
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.sabencostimes.domain.NYTNewsDataDomain
import com.example.sabencostimes.parceable.NYTNewsParceable

@Composable
fun NewsIndividualView(navController:NavHostController,news:NYTNewsParceable) {
    Column() {
        Text("This is Individual News")
        news.let {

            AsyncImage(model = it.imageURL, contentDescription = it.description)
            Text(it.title.toString())
            Text(it.description.toString())


        }


        }



    }
