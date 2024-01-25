package com.example.sabencostimes.dashboard

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.app.ComponentActivity
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.sabencostimes.domain.NYTMarketApiDomain
import com.example.sabencostimes.domain.ThreeCardDomain
import com.example.sabencostimes.ui.theme.InterFont
import com.example.sabencostimes.utils.convertDoubleToStringFormat
import com.example.sabencostimes.view.recyclableComponents.StockCardView
import com.example.sabencostimes.dashboard.DashboardViewModel
import com.example.sabencostimes.view.NewsListColumn

@Composable
fun DashboardLayout( navHostController: NavHostController,viewmodel: DashboardViewModel = viewModel(factory = null)){

    val stockMarketList by viewmodel.nytMarketApi.observeAsState( emptyList<NYTMarketApiDomain>())
    val newsList by viewmodel.newsList.observeAsState(initial = emptyList())
    Column(modifier=Modifier.padding(16.dp)){

        Text(text = "STOCK MARKET", fontFamily = InterFont)
        LazyRow(modifier = Modifier.fillMaxWidth(),
            state = rememberLazyListState()){
            items(items = stockMarketList) {it->
                Log.v("percemt",it.percentageChange.toString())
                val threeCardDomain = ThreeCardDomain(primaryData = convertDoubleToStringFormat(it.points), secondaryData = convertDoubleToStringFormat(it.percentageChange)+"%" , description = it.name)
                StockCardView(threeCardDomain = threeCardDomain, primaryModifier=Modifier )
            }

        }
        if(newsList.isNotEmpty()){
            Text(text = "BREAKING NEWS", fontFamily = InterFont)
            NewsListColumn(navHost = navHostController, newsList = newsList)
        }

    }

}