package com.example.sabencostimes.newsLetter

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.sabencostimes.domain.NYT_EVENING_US
import com.example.sabencostimes.domain.NYT_MORNING_EUROPE
import com.example.sabencostimes.repository.NYTNewsLetterRepository
import com.example.sabencostimes.view.recyclableComponents.NewsLetterCardView

@Composable
fun NewsletterDashboard( navHostController: NavHostController,respository:NYTNewsLetterRepository,  newsletterViewModel: NewsletterViewModel= viewModel(
   factory = NewsLetterViewModelFactory(repository = respository, NYT_EVENING_US)
)){

   val newsLetterList by newsletterViewModel.newsLetterList.observeAsState(emptyList())
   LazyColumn(){
      items(items = newsLetterList){
         NewsLetterCardView(navHostController,newsLetterDomain = it)
      }
   }

}