package com.example.sabencostimes.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
    LazyColumn() {
        items(items = newsList) {
            NewsCardView(nytNews = it)
        }
    }
}

