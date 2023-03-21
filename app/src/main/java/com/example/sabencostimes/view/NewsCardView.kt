package com.example.sabencostimes.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.sabencostimes.domain.NYTNewsDataDomain
import com.example.sabencostimes.domain.toParceable
import com.example.sabencostimes.navigation.NavigationConstant
import com.example.sabencostimes.parceable.NYTNewsParceable
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

@Composable
fun  NewsCardView(navHostController: NavHostController,nytNews:NYTNewsDataDomain) {
    Card{
        Row(

            horizontalArrangement = Arrangement.Center ,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),


        ) {
            AsyncImage(model = nytNews.imageURL, contentDescription = nytNews.title, modifier = Modifier.width(48.dp)
            )
            Text(text = (nytNews.title.toString()), fontSize = 20.sp, )
            Button(onClick = {
                val moshi = Moshi.Builder()
                    .add(KotlinJsonAdapterFactory())
                    .build()
                val jsonAdapter = moshi.adapter(NYTNewsParceable::class.java).lenient()
                val newsJson = jsonAdapter.toJson(nytNews.toParceable())
                navHostController.navigate(NavigationConstant.INDIVIDUAL_NEWS.replace("{news}",newsJson))
            }) {
               Text("See more")
            }
        }

    }
}
