package com.example.umbralis

import android.os.Build
import android.view.Gravity
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.material3.Text
import androidx.compose.ui.tooling.preview.Preview

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CharacterSelectionScreenUI() {
    val cinzel = FontFamily(Font(R.font.cinzel))
    val nightmare = FontFamily(Font(R.font.nightmare_pills))
    val context = LocalContext.current
    val density = context.resources.displayMetrics.density

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Black.copy(alpha = 0.7f))
                    .border(
                        width = 2.dp,
                        color = Color.Gray,
                        shape = RectangleShape
                    )
                    .padding(16.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "SELECCIÓN DE PERSONAJE",
                    fontFamily = cinzel,
                    color = Color.White,
                    fontSize = 20.sp,
                )

                Spacer(modifier = Modifier.height(8.dp))

                repeat(3) {
                    EmptyCharacterSlot()
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                StyledButton(text = "JUGAR") {}
                StyledButton(text = "CREAR") {}
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun EmptyCharacterSlot(characterName: String? = null, characterClass: String? = null, characterLevel: Int? = null, characterImage: Int? = null) {
    val context = LocalContext.current
    val density = context.resources.displayMetrics.density

    AndroidView(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        factory = {
            val layout = LinearLayout(context).apply {
                orientation = LinearLayout.HORIZONTAL
                setPadding(((16 * density).toFloat()).toInt(), ((8 * density).toFloat()).toInt(), ((16 * density).toFloat()).toInt(), ((8 * density).toFloat()).toInt()) // Reducido el padding
                gravity = Gravity.CENTER_VERTICAL
            }

            val imageContainer = LinearLayout(context).apply {
                val imageSize = ((80 * density).toFloat()).toInt()
                layoutParams = LinearLayout.LayoutParams(imageSize, imageSize).apply {
                    marginEnd = ((8 * density).toFloat()).toInt()
                }
                setBackgroundResource(R.drawable.edittext_style)
                gravity = Gravity.CENTER
            }

            val imageView = ImageView(context).apply {
                setImageResource(R.drawable.empty_character_icon)
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
            }
            imageContainer.addView(imageView)

            val textView = TextView(context).apply {
                text = "VACÍO"
                setTextColor(android.graphics.Color.WHITE)
                textSize = 14f
                typeface = context.resources.getFont(R.font.cinzel)
            }

            layout.addView(imageContainer)
            layout.addView(textView)
            layout
        }
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun StyledButton(text: String, onClick: () -> Unit) {
    val context = LocalContext.current
    val density = context.resources.displayMetrics.density

    AndroidView(
        factory = { context ->
            Button(context).apply {
                setBackgroundResource(R.drawable.button_style)
                setTextColor(android.graphics.Color.WHITE)
                setPadding(((24 * density).toFloat()).toInt(), ((8 * density).toFloat()).toInt(), ((24 * density).toFloat()).toInt(), ((8 * density).toFloat()).toInt())
                typeface = context.resources.getFont(R.font.nightmare_pills)
                textSize = 16f
                this.text = text
                setOnClickListener { onClick() }
            }
        },
        modifier = Modifier
            .height(48.dp)
            .width(120.dp)
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun CharacterSelectionScreenPreview() {
    CharacterSelectionScreenUI()
}