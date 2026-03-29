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
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import com.example.developmentandtesting.ui.theme.Accent
import com.example.developmentandtesting.ui.theme.Typography
import com.example.developmentandtesting.ui.theme.White
import com.example.developmentandtesting.ui.theme.backgroundGradient
import com.example.developmentandtesting.ui.theme.purpleGradient


@Composable
fun ProgramScreen(){

    val letters = listOf<Int>(
        R.drawable.lettera,
        R.drawable.letterb,
        R.drawable.letterc
    )

    var inputs by remember { mutableStateOf(arrayOf("","","")) }

    Column(modifier = Modifier.fillMaxSize()
        .background(purpleGradient),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween) {
        Text(
            "Введите размеры сторон!", style = Typography().Title1,
            color = White,
            textAlign = TextAlign.Center, modifier = Modifier.padding(top = 35.dp)
        )
        Column(modifier = Modifier.fillMaxHeight(0.7f),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(R.drawable.traengles),
                contentDescription = null,
                modifier = Modifier.padding(20.dp).widthIn(max = 400.dp).fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )
            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 250.dp),
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(15.dp),
                horizontalArrangement = Arrangement.Center
            )
            {

                items(3) {
                    Row(
                        modifier = Modifier.widthIn(max = 250.dp)
                            .padding(horizontal = 30.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Сторона ${it + 1}: ", style = Typography().Title2, color = White)
                        InputStr(
                            inputs[it],
                            { newValue ->
                                inputs = inputs.mapIndexed { i, v ->
                                    if (i == it) newValue else v
                                }.toTypedArray()
                            },
                            "0", letters[it]
                        )
                    }
                }
            }
        }

        val state = !inputs[0].isEmpty() && !inputs[1].isEmpty() && !inputs[2].isEmpty()

        UniversalButton("Проверить", {}, state)
    }

}

@Preview
@Composable
fun PreviewProgramScreen() {
    ProgramScreen()
}
