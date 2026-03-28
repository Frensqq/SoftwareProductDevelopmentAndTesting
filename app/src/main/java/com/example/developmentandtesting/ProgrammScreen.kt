package com.example.developmentandtesting

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.developmentandtesting.ui.theme.Typography
import com.example.developmentandtesting.ui.theme.White
import com.example.developmentandtesting.ui.theme.purpleGradient


@Composable
fun ProgramScreen(){

    val letters = listOf<Int>(
        R.drawable.lettera,
        R.drawable.letterb,
        R.drawable.letterc
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize()
        .background(purpleGradient),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,

    ) {items(3){
            Column() {
                Row(
                    modifier = Modifier.widthIn(max = 500.dp).fillMaxWidth(0.75f)
                        .padding(horizontal = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                )   {
                    Text("Сторона ${it + 1}: ", style = Typography().Title2, color = White)
                    InputStr("", {}, "0", letters[it])
                }
                Spacer(modifier = Modifier.height(25.dp))
            }
        }
    }

    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top) {
        Text("Введите размеры сторон!", style = Typography().Title1,
            color = White,
            textAlign = TextAlign.Center, modifier = Modifier.padding(30.dp))

        Image(painter = painterResource(R.drawable.traengles), contentDescription = null,
            modifier = Modifier.padding(20.dp).fillMaxWidth(), contentScale = ContentScale.FillWidth)



    }
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter) {

    }
}

@Preview
@Composable
fun PreviewProgramScreen() {
    ProgramScreen()
}
