package com.example.proyectofis.screens.menus

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.proyectofis.R
import com.example.proyectofis.components.NivelComponent
import com.example.proyectofis.navigation.AppScreens

@Composable
fun BrazoMenuScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        NivelComponent(
            modifier = Modifier
                .padding(16.dp)
                .weight(1f)
                .clickable { navController.navigate(route = AppScreens.BrazoPrincipianteScreen.route) },
            title = stringResource(R.string.principiante)
        )
        NivelComponent(
            modifier = Modifier
                .padding(16.dp)
                .weight(1f)
                .clickable { navController.navigate(route = AppScreens.BrazoIntermediocreen.route) },
            title = stringResource(R.string.intermedio)
        )
        NivelComponent(
            modifier = Modifier
                .padding(16.dp)
                .weight(1f)
                .clickable { navController.navigate(route = AppScreens.BrazoAvanzadoScreen.route) },
            title = stringResource(R.string.avanzado)
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun BrazoMenuComponentPreview() {
//    BrazoMenuComponent()
}