package com.example.sabencostimes.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.example.sabencostimes.R
import com.example.sabencostimes.domain.NYTMarketApiDomain
import com.example.sabencostimes.domain.ThreeCardDomain
import com.example.sabencostimes.ui.theme.InterFont
import com.example.sabencostimes.view.recyclableComponents.StockCardView
import com.example.sabencostimes.viewmodel.DashboardViewModel

@Composable
fun DashboardLayout( viewmodel:DashboardViewModel=DashboardViewModel()){

    val stockMarketList by viewmodel.nytMarketApi.observeAsState( emptyList<NYTMarketApiDomain>())
    Column(modifier=Modifier.padding(16.dp)){

        Text(text = "STOCK MARKET", fontFamily = InterFont)
        LazyRow(modifier = Modifier.fillMaxWidth(),
            state = rememberLazyListState()){
            items(items = stockMarketList) {it->
                val threeCardDomain = ThreeCardDomain(primaryData = it.points.toString(), secondaryData = it.percentageChange.toString(), description = it.name)
                StockCardView(threeCardDomain = threeCardDomain, primaryModifier=Modifier )
            }


        }
    }

}