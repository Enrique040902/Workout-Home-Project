package com.example.proyectofis.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.proyectofis.R
import com.example.proyectofis.navigation.AppScreens
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    LaunchedEffect(key1 = true) {
        delay(500)
        navController.popBackStack()
        if (FirebaseAuth.getInstance().currentUser?.email.isNullOrEmpty()) navController.navigate(AppScreens.LoginScreen.route)
        else navController.navigate(AppScreens.PrincipalScreen.route)
    }
    Splash()
}

@Composable
fun Splash() {
    val image = painterResource(id = R.drawable.logo)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = image,
            contentDescription = null
        )
    }
}

@Preview
@Composable
private fun SplashScreenPreview() {
    Splash()
}
