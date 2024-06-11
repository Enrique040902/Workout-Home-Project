package com.example.proyectofis.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.proyectofis.components.EjercicioComponent
import com.example.proyectofis.components.MenuComponent

@Composable
fun PrincipalScreen(
    navController: NavHostController,
    viewModel: PrincipalViewModel
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val ejerciciosRalizados = viewModel.ejerciciosRealizados
        val caloriasQuemadas = viewModel.caloriasQuemadas
        EjercicioComponent(
            ejerciciosRalizados.toString(),
            caloriasQuemadas.toString()
        )
        Log.d("Princial 1", "$ejerciciosRalizados     $caloriasQuemadas")
        MenuComponent(navController)
    }
}

@Preview(showSystemUi = true)
@Composable
fun PantallaPrincipalComponentPreview() {
}
