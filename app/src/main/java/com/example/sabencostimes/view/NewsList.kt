package com.example.sabencostimes.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.ImageLoader
import coil.compose.AsyncImage
import com.example.sabencostimes.domain.NYTNewsDataDomain

@Composable
fun NewsListColumn(newsList:List<NYTNewsDataDomain>){
    LazyColumn{
        items(items = newsList){
            Row(
                horizontalArrangement =Arrangement.Center ,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)



            ) {
//                Column() {
            AsyncImage(model = it.imageURL, contentDescription = it.description, modifier = Modifier.width(48.dp)
            )
                    Text(text = (it.title.toString()), fontSize = 20.sp, )

                }


            //}
            }
        }

    }

