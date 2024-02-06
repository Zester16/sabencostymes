package com.example.sabencostimes.newsLetter

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.sabencostimes.repository.NYTNewsLetterRepository
import com.example.sabencostimes.view.recyclableComponents.NewsLetterCardView

@Composable
fun NewsletterDashboard( navHostController: NavHostController,respository:NYTNewsLetterRepository,  newsletterDashboardViewModel: NewsletterDashboardViewModel= viewModel(
   factory = NewsLetterViewModelFactory(repository = respository)
)){

   val newsLetterList by newsletterDashboardViewModel.newsLetterList.observeAsState(emptyList())
   LazyColumn(){
      items(items = newsLetterList){
         NewsLetterCardView(navHostController,newsLetterDomain = it)
      }
   }

}