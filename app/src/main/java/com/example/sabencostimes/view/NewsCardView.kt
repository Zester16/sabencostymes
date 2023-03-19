package com.example.sabencostimes.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.sabencostimes.domain.NYTNewsDataDomain

@Composable
fun  NewsCardView(nytNews:NYTNewsDataDomain) {
    Card{
        Row(
            horizontalArrangement = Arrangement.Center ,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            AsyncImage(model = nytNews.imageURL, contentDescription = nytNews.title, modifier = Modifier.width(48.dp)
            )
            Text(text = (nytNews.title.toString()), fontSize = 20.sp, )
        }

    }
}
