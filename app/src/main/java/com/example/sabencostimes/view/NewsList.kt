package com.example.sabencostimes.view

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.sabencostimes.domain.NYTNewsDataDomain

@Composable
fun NewsListColumn(newsList:List<NYTNewsDataDomain>){
    LazyColumn{
        items(items = newsList){
               Text(text = (it.description.toString()))
            }
        }

    }

