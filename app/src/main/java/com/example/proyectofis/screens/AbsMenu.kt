package com.example.proyectofis.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.proyectofis.R
import com.example.proyectofis.components.NivelComponent

@Composable
fun AbsMenuComponent(){
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        NivelComponent(
            modifier = Modifier
                .padding(16.dp)
                .weight(1f)
                .clickable { /* TODO */ },
            title = stringResource(R.string.principiante)
        )
        NivelComponent(
            modifier = Modifier
                .padding(16.dp)
                .weight(1f)
                .clickable { /* TODO */ },
            title = stringResource(R.string.intermedio)
        )
        NivelComponent(
            modifier = Modifier
                .padding(16.dp)
                .weight(1f)
                .clickable { /* TODO */ },
            title = stringResource(R.string.avanzado)
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun AbsMenuComponentPreview(){
    AbsMenuComponent()
}