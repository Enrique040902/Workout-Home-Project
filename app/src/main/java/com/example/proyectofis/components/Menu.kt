package com.example.proyectofis.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.proyectofis.components.grupos.AbsComponent
import com.example.proyectofis.components.grupos.BrazoComponent
import com.example.proyectofis.components.grupos.PechoComponent
import com.example.proyectofis.components.grupos.PiernaComponent

@Composable
private fun MenuComponent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PechoComponent()
        AbsComponent()
        BrazoComponent()
        PiernaComponent()
    }
}

@Preview(
    showSystemUi = true
)
@Composable
private fun MenuComponentPreview() {
    MenuComponent()
}