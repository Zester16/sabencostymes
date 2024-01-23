package com.example.sabencostimes.view

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.sabencostimes.R
import com.example.sabencostimes.domain.NYTNewsDataDomain
import com.example.sabencostimes.domain.toParceable
import com.example.sabencostimes.navigation.NavigationConstant
import com.example.sabencostimes.parceable.NYTNewsParceable
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

@Composable
fun  NewsCardView(navHostController: NavHostController,nytNews:NYTNewsDataDomain) {
    Card(elevation = 10.dp){
        val webIcon = painterResource(id = R.drawable.language)
        val readIcon = painterResource(id = R.drawable.read)
        val shareIcon = painterResource(id = R.drawable.share
        )
        val context = LocalContext.current
        Column(
            Modifier
                .fillMaxWidth()
                .padding(8.dp)) {
            Row(horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                ) {
                AsyncImage(
                    model = nytNews.imageURL,
                    contentDescription = nytNews.title,
                    modifier = Modifier.width(48.dp)
                )
                Text(
                    text = (nytNews.title.toString()),
                    fontSize = 20.sp,
                    style = MaterialTheme.typography.h1
                )
            }
            Row() {
                Button(onClick = {
                    val moshi = Moshi.Builder()
                        .add(KotlinJsonAdapterFactory())
                        .build()
                    val jsonAdapter = moshi.adapter(NYTNewsParceable::class.java).lenient()
                    val newsJson = jsonAdapter.toJson(nytNews.toParceable())
                    navHostController.navigate(NavigationConstant.INDIVIDUAL_NEWS.replace("{news}",newsJson)){
                        //launchSingleTop = true
                        //restoreState = true
                    }
                },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
                    ) {
                    Image(painter = readIcon, contentDescription = "")
                }
                Button(onClick = {

                    navHostController.navigate(NavigationConstant.WEB_VIEW_PATH.replace("{webUrl}",nytNews.url.toString())){
                        //launchSingleTop = true
                        //restoreState = true
                    }
                },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
                ){
                    Image(painter = (webIcon), contentDescription = "browser",Modifier.background(color = Color.White))
                }
                Button(onClick ={
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(nytNews.url))
                    startActivity(context, intent, null)
                } ,
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
                ){
                    Image(painter = (shareIcon), contentDescription = "browser",Modifier.background(color = Color.White))

                }
            }

        }
            }



    }

