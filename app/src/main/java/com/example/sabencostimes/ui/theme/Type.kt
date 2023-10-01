package com.example.sabencostimes.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.sabencostimes.R

// Set of Material typography styles to start with
val Oswald = FontFamily(
    Font(R.font.oswald_medium)
)
val InterFont= FontFamily(
    Font(R.font.young_serif),
)
val Typography = Typography(
    h1= TextStyle(
        fontFamily = Oswald,
        fontSize = 32.sp,
        fontWeight = FontWeight.W400,
        fontStyle = FontStyle.Italic
    ),
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )


    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)