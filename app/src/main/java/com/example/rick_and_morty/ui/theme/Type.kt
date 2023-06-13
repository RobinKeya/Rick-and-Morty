package com.example.rick_and_morty.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.rick_and_morty.R

val PoppinsRegular = FontFamily(
    Font(R.font.poppins_regular)
)
// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = PoppinsRegular,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        color = Color.Gray
    ),
    h2 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
        color = Color.Black,
        fontFamily = PoppinsRegular
    ),
    h1 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontFamily = PoppinsRegular,
        fontSize = 24.sp
    ),
    h3 = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp,
        fontFamily = PoppinsRegular,
        color = Color.Black
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