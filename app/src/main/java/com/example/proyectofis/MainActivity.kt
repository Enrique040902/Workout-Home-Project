package com.example.proyectofis

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.proyectofis.navigation.AppNavigation
import com.example.proyectofis.navigation.AppScreens
import com.example.proyectofis.screens.login.LoginScreen
import com.example.proyectofis.screens.login.LoginViewModel
import com.example.proyectofis.screens.registro.RegistroScreen
import com.example.proyectofis.screens.registro.RegistroViewModel
import com.example.proyectofis.ui.theme.PROYECTOFISTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PROYECTOFISTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    LoginScreen(viewModel = LoginViewModel())
                    AppNavigation()
                }
            }
        }
    }
}

@Preview
@Composable
private fun MainActivityPreview() {
    AppNavigation()
}