package com.example.sabencostimes.view.recyclableComponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sabencostimes.domain.ThreeCardDomain

@Composable
fun StockCardView(threeCardDomain:ThreeCardDomain,primaryModifier:Modifier){

    Card(Modifier.padding(16.dp)) {
    Column {
        Text(threeCardDomain.primaryData,primaryModifier, fontSize = 32.sp)
        Text(threeCardDomain.secondaryData)
        Text(text = threeCardDomain.description)
    }
    }
}