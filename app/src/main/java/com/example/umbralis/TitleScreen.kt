package com.example.umbralis

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.umbralis.ui.theme.Black
import com.example.umbralis.ui.theme.White
import kotlinx.coroutines.delay

class TitleScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            titleScreenContent()
        }
    }
}

@Composable
fun titleScreenContent() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable {  }
    ) {
        backgroundTitleScreen()
        logoTitleScreen()
        titleScreenDarkin()
    }
}

@Composable
fun backgroundTitleScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Black)
    )
}

@Composable
fun logoTitleScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()

    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "logo",
            modifier = Modifier
                .align(Alignment.TopCenter)
                .fillMaxWidth(1f)
                .aspectRatio(1f)
        )
    }
}

@Composable
fun titleScreenDarkin() {
    val screenHeight = LocalConfiguration.current.screenHeightDp
    val verticalOffset = (screenHeight * 0.85).dp

    var visible by remember { mutableStateOf(true) }
    val alpha by animateFloatAsState(
        targetValue = if (visible) 1f else 0f,
        animationSpec = tween(durationMillis = 1000)
    )

    LaunchedEffect(Unit) {
        while (true) {
            visible = !visible
            delay(1000)
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.title_screen_darkin),
            contentDescription = "darkin",
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth(1f)
                .scale(1.6f)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = verticalOffset),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "¡Toca la pantalla para comenzar!",
                color = White.copy(alpha = alpha),
                fontSize = 30.sp,
                fontFamily = FontFamily(Font(R.font.jimnightshade_regular))
            )
        }
    }
}

@Preview
@Composable
fun PreviewTitleScreen() {
    titleScreenContent()
}
