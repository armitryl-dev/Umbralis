package com.example.umbralis

import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun LoginScreenUI(navController: NavController) {
    val cinzel = FontFamily(Font(R.font.cinzel))

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {

            Image(
                painter = painterResource(id = R.drawable.logo_no_background),
                contentDescription = "Logo",
                modifier = Modifier
                    .size(250.dp)
                    .padding(bottom = 24.dp)
            )

            Text(
                text = "INICIAR SESIÓN",
                fontFamily = cinzel,
                color = Color.White,
                fontSize = 30.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            AndroidEditText(hint = "Usuario")

            Spacer(modifier = Modifier.height(16.dp))

            AndroidEditText(hint = "Contraseña")

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "¿CONTRASEÑA OLVIDADA?",
                fontFamily = cinzel,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(16.dp))

            AndroidStyledButton("INICIAR SESIÓN") {

            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "¿NO TIENES UNA CUENTA?",
                fontFamily = cinzel,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(16.dp))

            AndroidStyledButton("REGISTRARSE") {
                navController.navigate("registerScreen")
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AndroidEditText(hint: String) {
    val context = LocalContext.current
    AndroidView(
        modifier = Modifier
            .fillMaxWidth(0.8f)
            .height(50.dp),
        factory = {
            EditText(context).apply {
                setHint(hint)
                setTextColor(android.graphics.Color.WHITE)
                setHintTextColor(android.graphics.Color.LTGRAY)
                setBackgroundResource(R.drawable.edittext_style)
                textSize = 16f
                typeface = context.resources.getFont(R.font.cinzel)
                setPadding(30, 10, 30, 10)
            }
        }
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AndroidStyledButton(text: String, onClick: () -> Unit) {
    val context = LocalContext.current
    AndroidView(
        modifier = Modifier
            .fillMaxWidth(0.6f)
            .height(48.dp),
        factory = {
            Button(context).apply {
                setText(text)
                setTextColor(android.graphics.Color.WHITE)
                setBackgroundResource(R.drawable.button_style)
                textSize = 16f
                typeface = context.resources.getFont(R.font.nightmare_pills)
                setOnClickListener { onClick() }
            }
        }
    )
}
