package com.example.umbralis

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                UmbralisNavHost()
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun UmbralisNavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "titleScreen") {
        composable("titleScreen") {
            titleScreenContent {
                navController.navigate("loginScreen")
            }
        }
        composable("loginScreen") {
            LoginScreenUI(navController)
        }
        composable("registerScreen") {
            RegisterScreenUI(navController)
        }
        composable("CharacterSelectionScreenUI") {
            CharacterSelectionScreenUI()
        }
    }
}
