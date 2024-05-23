package com.example.proyectofis.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.proyectofis.components.EjercicioComponent
import com.example.proyectofis.components.MenuComponent

@Composable
fun PrincipalScreen(navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        EjercicioComponent()
        MenuComponent(navController)
    }
}

//@Preview(showSystemUi = true)
//@Composable
//fun PantallaPrincipalComponentPreview() {
//    PrincipalScreen(navController)
//}