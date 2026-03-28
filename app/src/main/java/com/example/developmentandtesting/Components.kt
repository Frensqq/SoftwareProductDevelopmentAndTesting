package com.example.developmentandtesting


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.developmentandtesting.ui.theme.Black
import com.example.developmentandtesting.ui.theme.InputBg
import com.example.developmentandtesting.ui.theme.InputIcon
import com.example.developmentandtesting.ui.theme.InputStr
import com.example.developmentandtesting.ui.theme.Placeholder
import com.example.developmentandtesting.ui.theme.Typography
import com.example.developmentandtesting.ui.theme.colorsOutlinedTextField

@Composable
fun InputStr(value: String, onChangeValue: (String) -> Unit, text: String, icon: Int){

    OutlinedTextField(
        value = value,
        onValueChange = {onChangeValue(it)} ,
        colors = colorsOutlinedTextField(),
        modifier = Modifier.width(100.dp).height(50.dp),
        shape = RoundedCornerShape(15.dp),
        leadingIcon = {
            Icon(
               painter = painterResource(icon),
                modifier = Modifier.size(20.dp),
               tint = Black, contentDescription = null,
            )
        },
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

@Preview
@Composable
fun PreviewInputStr(){

    var message by remember{mutableStateOf("")}


    InputStr(message, {message = it}, "5", 1)
}
