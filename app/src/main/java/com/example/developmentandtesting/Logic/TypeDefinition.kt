package com.example.developmentandtesting.Logic

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.LineHeightStyle
import com.example.developmentandtesting.Components.DialogWindow
import com.example.developmentandtesting.Components.ErrorWindow
import com.example.developmentandtesting.ui.theme.Description

@Composable
fun TypeDefinition(aX: String, bX: String, cX: String): Int{

    var a = 0.00
    var b = 0.00
    var c = 0.00

    var stateError by remember { mutableStateOf(false) }
    var state by remember { mutableStateOf(false) }
    var text by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var type by remember { mutableStateOf(-1) }

    if(!stateError){
        text = ""
        description = ""
    }
    if(!state){
        description = ""
        type = -1
    }


    try {
        a = aX.toDouble()
    }
    catch(e: Exception) {
        text = "Ошибка типа данных"
        description = "невозможно проброзовть A в Double"
        stateError = true
    }
    try {
        b = bX.toDouble()
    }
    catch(e: Exception){

        text = "Ошибка типа данных"
        description = "невозможно проброзовть B в Double"
        stateError = true
    }
    try {
        c = cX.toDouble()
    }
    catch(e: Exception) {
        stateError = true
        text = "Ошибка типа данных"
        description = "невозможно проброзовть C в Double"
    }

    if (!stateError){
        if (a == b && b == c){
            type = 2
            state = true
        }
        else if (a == b || b == c || c == a){
            type = 1
            state = true
        }
        else{
            type = 0
            state = true
        }

    }



    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        if (stateError){
            ErrorWindow(text, description) {stateError = it}
            return -1
        }
        else if (state && type != -1){
            DialogWindow(type, {state = it})
            return 1
        }
        else{
            return 0
        }

    }
    return 0
}