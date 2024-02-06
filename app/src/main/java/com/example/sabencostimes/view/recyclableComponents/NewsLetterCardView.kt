package com.example.sabencostimes.view.recyclableComponents


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.sabencostimes.R
import com.example.sabencostimes.domain.NYTNewsLetterDomain

import com.example.sabencostimes.ui.theme.Oswald
import com.example.sabencostimes.utils.invokeNavigationToInternalWebBrowser


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun NewsLetterCardView(navHostController: NavHostController,newsLetterDomain: NYTNewsLetterDomain) {
    Column(modifier = Modifier.padding(16.dp)) {

        Card( onClick ={
            invokeNavigationToInternalWebBrowser(newsLetterDomain.url,navHostController)

        } ) {
            Column {
                AsyncImage(model = newsLetterDomain.imgSrc, contentDescription = newsLetterDomain.date, alignment = Alignment.Center, modifier = Modifier.fillMaxSize(), )
                Text(text = newsLetterDomain.date, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center, fontFamily = FontFamily.Monospace, fontSize = 16.sp)
                Text(text = newsLetterDomain.title, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center, fontFamily = Oswald, fontSize = 24.sp)
                Row(modifier = Modifier.height(2.dp).background(colorResource(id = R.color.black)).fillMaxWidth(), ){}
            }
        }
    }


}