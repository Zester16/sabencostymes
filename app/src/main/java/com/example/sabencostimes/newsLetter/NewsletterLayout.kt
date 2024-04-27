package com.example.sabencostimes.newsLetter

import android.icu.text.CaseMap.Title
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.sabencostimes.domain.NYTNewsletterURLMap
import com.example.sabencostimes.domain.NYT_DEALBOOK
import com.example.sabencostimes.domain.NYT_EVENING_US
import com.example.sabencostimes.domain.NYT_MORNING_EUROPE
import com.example.sabencostimes.navigation.NavigationConstant
import com.example.sabencostimes.repository.NYTNewsLetterRepository
import com.example.sabencostimes.view.recyclableComponents.NewsLetterCardView

@Composable
fun NewsletterView( navHostController: NavHostController,respository:NYTNewsLetterRepository,  newsId:String,newsletterViewModel: NewsletterViewModel= viewModel(
   factory = NewsLetterViewModelFactory(repository = respository, newsId)
)){

   val newsLetterList by newsletterViewModel.newsLetterList.observeAsState(emptyList())
   LazyColumn(){
      items(items = newsLetterList){
         NewsLetterCardView(navHostController,newsLetterDomain = it)
      }
   }

}
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun NewsLetterDashboardView(navHostController: NavHostController){
   Column(modifier = Modifier.fillMaxSize(),
           verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally
   )         {
      Text(text = "NYT Newsletter")
      NYTNewsletterURLMap.forEach { entry ->
            Card(onClick = {  navHostController.navigate(NavigationConstant.NEWSLETTER_LIST.replace("{news_id}",entry.key))}, modifier = Modifier.fillMaxWidth()) {
               Image(painter = painterResource(entry.value.image), contentDescription ="News" )
            }
      }
   }
}