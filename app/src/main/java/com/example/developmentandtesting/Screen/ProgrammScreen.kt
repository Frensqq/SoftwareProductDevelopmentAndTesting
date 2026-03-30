package com.example.developmentandtesting.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.developmentandtesting.Components.DialogWindow
import com.example.developmentandtesting.Components.ErrorWindow
import com.example.developmentandtesting.Components.InputStr
import com.example.developmentandtesting.R
import com.example.developmentandtesting.Components.UniversalButton
import com.example.developmentandtesting.Logic.TriangleResult
import com.example.developmentandtesting.Logic.defineTriangle
import com.example.developmentandtesting.ui.theme.Typography
import com.example.developmentandtesting.ui.theme.White
import com.example.developmentandtesting.ui.theme.purpleGradient


@Composable
fun ProgramScreen() {

    val letters = listOf(
        R.drawable.lettera,
        R.drawable.letterb,
        R.drawable.letterc
    )

    var inputs by remember { mutableStateOf(arrayOf("", "", "")) }

    var result by remember { mutableStateOf<Int?>(null) }
    var errorTitle by remember { mutableStateOf<String?>(null) }
    var errorDescription by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(purpleGradient),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Text(
            "Введите размеры сторон!",
            style = Typography().Title1,
            color = White,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 35.dp)
        )

        Column(
            modifier = Modifier.fillMaxHeight(0.7f),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(R.drawable.traengles),
                contentDescription = null,
                modifier = Modifier
                    .padding(20.dp)
                    .widthIn(max = 400.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )

            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 250.dp),
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(15.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                items(3) {
                    Row(
                        modifier = Modifier
                            .widthIn(max = 250.dp)
                            .padding(horizontal = 30.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                    Text(
                            "Сторона ${it + 1}: ",
                            style = Typography().Title2,
                            color = White
                        )

                        InputStr(
                            inputs[it],
                            { newValue ->
                                inputs = inputs.mapIndexed { i, v ->
                                    if (i == it) newValue else v
                                }.toTypedArray()
                            },
                            "0",
                            letters[it]
                        )
                    }
                }
            }
        }

        val enabled = inputs.all { it.isNotEmpty() }

        Box(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {

            UniversalButton("Проверить", {

                val resultData = defineTriangle(
                    inputs[0],
                    inputs[1],
                    inputs[2]
                )

                when (resultData) {
                    is TriangleResult.Success -> {
                        result = resultData.type
                    }

                    is TriangleResult.Error -> {
                        errorTitle = resultData.title
                        errorDescription = resultData.description
                    }
                }

            }, enabled)
        }
    }
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center) {
        if (result != null) {
            DialogWindow(result!!) {
                result = null
            }
        }

        if (errorTitle != null && errorDescription != null) {
            ErrorWindow(errorTitle!!, errorDescription!!) {
                errorTitle = null
                errorDescription = null
            }
        }
    }
}





@Preview
@Composable
fun PreviewProgramScreen() {
    ProgramScreen()
}
