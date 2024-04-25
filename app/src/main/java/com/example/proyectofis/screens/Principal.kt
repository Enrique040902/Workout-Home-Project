package com.example.proyectofis.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.proyectofis.components.EjercicioComponent
import com.example.proyectofis.components.MenuComponent

@Composable
fun PantallaPrincipalComponent() {

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        EjercicioComponent()
        MenuComponent()
    }
}

@Preview(showSystemUi = true)
@Composable
fun PantallaPrincipalComponentPreview() {
    PantallaPrincipalComponent()
}