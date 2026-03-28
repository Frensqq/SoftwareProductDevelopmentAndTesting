package com.example.developmentandtesting.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val White = Color(0xffffffff)
val Black = Color(0xff000000)

@Composable
fun backgroundGradient() = Brush.linearGradient(
    listOf(
        Color(0xffB4D5FF),
        Color(0xff60A6FD)
    )
)

val greenGradient = Brush.linearGradient(
    listOf(
        Color(0xff75D8BC),
        Color(0xff5BADCB)
    )
)

val blueGradient = Brush.linearGradient(
    listOf(
        Color(0xffB4D5FF),
        Color(0xff60A6FD)
    )
)