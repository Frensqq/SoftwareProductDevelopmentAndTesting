package com.example.developmentandtesting.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

data class typo(

    val Title1:  TextStyle = TextStyle(),
    val Title2:  TextStyle = TextStyle(),
    val Title3:  TextStyle = TextStyle(),
    val Text:  TextStyle = TextStyle(),

)

fun Typography(): typo{

    fun textStyle(
        fontSize: Int,
        fontWeight: Int,
        lineHeight: Int,
        letterSpacing: Double = 0.00,
        textAlign: TextAlign = TextAlign.Unspecified


    ) =
        TextStyle(
            fontSize = fontSize.sp,
            fontWeight = FontWeight(fontWeight),
            letterSpacing = letterSpacing.sp,
            lineHeight = lineHeight.sp,
            textAlign = textAlign
        )

    return typo(
        textStyle( 40,600,38, 0.33 ),
        textStyle( 24,700,28, 0.33 ),
        textStyle( 18,400,28, 0.38,  TextAlign.Center),
        textStyle( 14,400,20  ),

    )
}