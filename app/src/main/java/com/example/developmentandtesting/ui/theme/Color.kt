package com.example.developmentandtesting.ui.theme

import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val Accent = Color(0xff782bda)
val AccentInactive = Color(0xffb39ae6)
val Black = Color(0xff000000)
val White = Color(0xffffffff)
val Error = Color(0xffFD3535)
val Success = Color(0xff00B712)
val InputBg = Color(0xffF5F5F9)
val InputStr = Color(0xffEBEBEB)
val InputIcon = Color(0xffB8C1CC)
val Placeholder = Color(0xff939396)
val Description = Color(0xff7E7E9A)
val CardStr = Color(0xffF4F4F4)

@Composable
fun backgroundGradient() = Brush.linearGradient(
    listOf(
        Color(0xffB4D5FF),
        Color(0xff60A6FD)
    )
)


val purpleGradient = Brush.linearGradient(
    listOf(
        Color(0xff9d81ba),
        Color(0xff5BADCB)
    )
)

@Composable
fun colorsOutlinedTextField() = OutlinedTextFieldDefaults.colors(
    unfocusedTextColor = Black,
    unfocusedBorderColor = AccentInactive,
    unfocusedPlaceholderColor = Placeholder,
    unfocusedContainerColor = InputBg,

    focusedTextColor = Black,
    focusedBorderColor = Accent,
    focusedPlaceholderColor = Placeholder,
    focusedContainerColor = InputBg,

    errorTextColor = Black,
    errorBorderColor = Error,
    errorPlaceholderColor = Placeholder,
    errorContainerColor = Error.copy(alpha = 0.1f),

    cursorColor = Accent,
    errorCursorColor = Accent
)

val blueGradient = Brush.linearGradient(
    listOf(
        Color(0xffB4D5FF),
        Color(0xff60A6FD)
    )
)

@Composable
fun colorButton() = ButtonDefaults.buttonColors(
    disabledContentColor = InputStr,
    disabledContainerColor = AccentInactive,
    containerColor = Accent,
    contentColor = White
)