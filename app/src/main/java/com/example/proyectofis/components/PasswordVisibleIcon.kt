package com.example.proyectofis.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState

@Composable
fun PasswordVisibleIcon(passwordVisible: MutableState<Boolean>) {

    val icon = if (passwordVisible.value) Icons.Default.VisibilityOff else Icons.Default.Visibility

    IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
        Icon(imageVector = icon, contentDescription = null)
    }
}