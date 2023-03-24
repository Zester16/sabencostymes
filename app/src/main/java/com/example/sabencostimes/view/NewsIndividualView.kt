package com.example.sabencostimes.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.sabencostimes.domain.NYTNewsDataDomain
import com.example.sabencostimes.parceable.NYTNewsParceable

@Composable
fun NewsIndividualView(navController:NavHostController,news:NYTNewsParceable) {
    Column(

        modifier= Modifier
        .fillMaxSize()
            .padding(16.dp)
        ,
        //verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("This is Individual News")
        news.let {


            //AsyncImage(model = it.imageURL, contentDescription = it.description,)
            Text(it.title.toString(), fontSize = 32.sp)
            Text(it.description.toString(), fontSize = 24.sp)
        }

        }

    }
