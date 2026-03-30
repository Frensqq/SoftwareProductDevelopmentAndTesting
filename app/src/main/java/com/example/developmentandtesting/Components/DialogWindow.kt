package com.example.developmentandtesting.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.developmentandtesting.R
import com.example.developmentandtesting.ui.theme.Accent
import com.example.developmentandtesting.ui.theme.Error
import com.example.developmentandtesting.ui.theme.Placeholder
import com.example.developmentandtesting.ui.theme.Typography
import com.example.developmentandtesting.ui.theme.White

data class Figure(
    val type: Int,
    val description: String
)

@Composable
fun DialogWindow(State: Int, onClick: (Boolean) -> Unit){

    val text = arrayOf<Figure>(
        Figure(R.drawable.type0,"Разносторонний"),
        Figure(R.drawable.type1,"Равнобедренный"),
        Figure(R.drawable.type2,"Равносторонний"),
    )

    Column(
        modifier = Modifier.padding(20.dp)
            .fillMaxWidth(0.7f)
            .heightIn(min = 120.dp, max = 400.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(White)
            .border(1.dp, Accent, RoundedCornerShape(15.dp)),
                horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text("Успешно!", style = Typography().Title2, modifier = Modifier.padding(top= 5.dp))
        Box(modifier = Modifier.padding(top= 5.dp).height(1.dp).fillMaxWidth().background(Accent))

        Image(painter = painterResource(text[State].type),
            contentDescription = null, modifier = Modifier.size(100.dp))

        Text("Треугольник - ${text[State].description}",
            style = Typography().Text,
            textAlign = TextAlign.Center)

        ExitButton(onClick, false)
    }

}

@Composable
fun ErrorWindow(error: String, description: String, onClick: (Boolean) -> Unit){
    Column(
        modifier = Modifier.padding(20.dp)
            .fillMaxWidth(0.7f)
            .heightIn(min = 120.dp, max = 400.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(White)
            .border(1.dp, Error, RoundedCornerShape(15.dp)),
            horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)


    ) {
        Text("Ошибка!", style = Typography().Title2, modifier = Modifier.padding(top= 5.dp))

        Box(modifier = Modifier.padding(top= 5.dp).height(1.dp).fillMaxWidth().background(Error))

        Text(error, style = Typography().Text, textAlign = TextAlign.Center)

        Text(description, style = Typography().Text, textAlign = TextAlign.Center, color = Placeholder)

        ExitButton(onClick, true)
    }
}

@Preview
@Composable
fun PreviewDialogWindow(){

    DialogWindow(1, {})

}