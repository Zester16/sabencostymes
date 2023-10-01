package com.example.sabencostimes.view.recyclableComponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sabencostimes.R
import com.example.sabencostimes.domain.ThreeCardDomain
import kotlin.math.round

@Composable
fun StockCardView(threeCardDomain:ThreeCardDomain,primaryModifier:Modifier){
    val interFont= FontFamily(
        Font(R.font.inter_500),

    )
    Card(modifier = Modifier.padding(16.dp)
        .width(192.dp)
        ,
        shape = RoundedCornerShape(8.dp),
        elevation = 8.dp

    ) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(threeCardDomain.primaryData,primaryModifier, fontSize = 32.sp, fontFamily = interFont)
        Text(threeCardDomain.secondaryData, fontSize = 24.sp, textAlign = TextAlign.Center)
        Text(text = threeCardDomain.description)
    }
    }
}