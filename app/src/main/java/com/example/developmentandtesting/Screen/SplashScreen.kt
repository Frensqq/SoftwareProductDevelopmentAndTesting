package com.example.developmentandtesting.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.developmentandtesting.R
import com.example.developmentandtesting.ViewModel.SplashViewModel
import com.example.developmentandtesting.ui.theme.Typography
import com.example.developmentandtesting.ui.theme.White
import com.example.developmentandtesting.ui.theme.purpleGradient


@Composable
fun SplashScreenCustom(Navcontroller: NavHostController, viewModel: SplashViewModel = viewModel()){
    viewModel.launch(Navcontroller)
    Column(modifier = Modifier
        .fillMaxSize()
        .background(purpleGradient)
        , horizontalAlignment = Alignment.CenterHorizontally
        , verticalArrangement = Arrangement.Center) {

        val configuration = LocalConfiguration.current
        val screenWidth = configuration.screenWidthDp.dp
        val screenHeight = configuration.screenHeightDp.dp
        val squareSize = minOf(screenWidth, screenHeight) / 2

        Box(modifier = Modifier.shadow(
            elevation = 30.dp,
            shape = CircleShape,
            clip = false
            )
            .clip(CircleShape)
            .background(White).size(squareSize),
            contentAlignment = Alignment.Center,  )  {

            Image(painter = painterResource(R.drawable.splash),
                modifier = Modifier.scale(0.8f),
                contentDescription = null, contentScale = ContentScale.FillHeight)

        }

        Spacer(modifier = Modifier.height(25.dp))

        Text(text = "Расчет сторон теругольника", style = Typography().Title1,
            textAlign = TextAlign.Center,

            color = White)

    }
}



//@Preview
//@Composable
//fun PreviewSplashScreenCustom(){
//    SplashScreenCustom()
//}
