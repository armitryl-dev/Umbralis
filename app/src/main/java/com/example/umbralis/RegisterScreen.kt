package com.example.umbralis

import android.os.Build
import android.widget.Button
import android.widget.EditText
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun RegisterScreenUI(navController: NavController) {
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
                text = "REGISTRARSE",
                fontFamily = cinzel,
                color = Color.White,
                fontSize = 30.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            AndroidEditText(hint = "Usuario")

            Spacer(modifier = Modifier.height(12.dp))

            AndroidEditText(hint = "Contraseña")

            Spacer(modifier = Modifier.height(12.dp))

            AndroidEditText(hint = "Repita la contraseña")

            Spacer(modifier = Modifier.height(20.dp))

            AndroidStyledButton("CREAR CUENTA") {
                navController.navigate("loginScreen")
            }
        }
    }
}
