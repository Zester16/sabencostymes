package com.example.sabencostimes.view

import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.sabencostimes.R

@Composable
fun CircleProgressIndicator(){
    CircularProgressIndicator(
        // below line is use to add padding
        // to our progress bar.
        modifier = Modifier.padding(16.dp),

        // below line is use to add color
        // to our progress bar.
        color = colorResource(id = R.color.purple_200),

        // below line is use to add stroke
        // width to our progress bar.
        strokeWidth = Dp(value = 4F)
    )

}