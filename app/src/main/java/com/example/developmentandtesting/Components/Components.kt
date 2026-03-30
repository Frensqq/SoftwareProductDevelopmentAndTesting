package com.example.developmentandtesting.Components


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.developmentandtesting.ui.theme.Accent
import com.example.developmentandtesting.ui.theme.AccentInactive
import com.example.developmentandtesting.ui.theme.Error
import com.example.developmentandtesting.ui.theme.Placeholder
import com.example.developmentandtesting.ui.theme.Typography
import com.example.developmentandtesting.ui.theme.White
import com.example.developmentandtesting.ui.theme.colorButton
import com.example.developmentandtesting.ui.theme.colorsOutlinedTextField

@Composable
fun InputStr(value: String, onChangeValue: (String) -> Unit, text: String, icon: Int){

    OutlinedTextField(
        value = value,
        onValueChange = {
            if (it.length <= 4) {
                onChangeValue(it)
            } } ,
        colors = colorsOutlinedTextField(),
        modifier = Modifier.width(100.dp).height(50.dp),
        shape = RoundedCornerShape(15.dp),
        leadingIcon = {
            Icon(
               painter = painterResource(icon),
                modifier = Modifier.size(20.dp),
               tint = Accent, contentDescription = null,
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        placeholder = {
            Text(
                text = text, style = Typography().Title3,
                color = Placeholder,
                modifier = Modifier.height(40.dp).fillMaxSize(),
                textAlign = TextAlign.Center
            )
        },

        singleLine = true,
        textStyle = Typography().Title3
    )
}

@Composable
fun UniversalButton(text: String, onClick: () -> Unit, state: Boolean){
    Button(
        onClick = onClick,
        enabled = state,
        shape = RoundedCornerShape(15.dp),
        border = if (state) BorderStroke(2.dp, AccentInactive) else null,
        modifier = Modifier.height(60.dp)
            .fillMaxWidth(0.5f),
        colors = colorButton()
    ) {
        Text(text = text, style = Typography().Title2, color = White)
    }
}

@Composable
fun ExitButton(onClick: (Boolean) -> Unit, isError: Boolean){
    Box(modifier = Modifier.fillMaxWidth().height(50.dp).background(if (isError) Error else Accent )
        .clickable {
        onClick(false)
    },
        contentAlignment = Alignment.Center
    ) {
        Text(
            "Закрыть", style = Typography().Text, textAlign = TextAlign.Center,
            color = White,
            )
    }
}

@Preview
@Composable
fun PreviewInputStr(){

    var message by remember{mutableStateOf("")}


    InputStr(message, {message = it}, "5", 1)


    UniversalButton("Решить", {}, true)
}
