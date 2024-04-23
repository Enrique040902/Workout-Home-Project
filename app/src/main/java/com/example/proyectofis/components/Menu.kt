package com.example.proyectofis.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.proyectofis.components.grupos.AbsComponent
import com.example.proyectofis.components.grupos.BrazoComponent
import com.example.proyectofis.components.grupos.PechoComponent
import com.example.proyectofis.components.grupos.PiernaComponent

@Composable
fun MenuComponent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .weight(1f)
        ) {
            PechoComponent(modifier = Modifier.weight(1f).padding(16.dp).height(150.dp))
            BrazoComponent(modifier = Modifier.weight(1f).padding(16.dp).height(150.dp))
        }
        Row(
            modifier = Modifier
                .weight(1f)
        ) {
            AbsComponent(modifier = Modifier.weight(1f).padding(16.dp).height(150.dp))
            PiernaComponent(modifier = Modifier.weight(1f).padding(16.dp).height(150.dp))
        }
    }
}

@Preview(
    showSystemUi = true
)
@Composable
private fun MenuComponentPreview() {
    MenuComponent()
}