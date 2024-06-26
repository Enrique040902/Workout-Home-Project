package com.example.proyectofis.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.proyectofis.R

@Composable
fun WarningPopUpComponent(
    showPopUp: Boolean,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    if (showPopUp) {
        AlertDialog(
            onDismissRequest = { onDismiss() },
            confirmButton = {
                TextButton(onClick = { onConfirm() }) {
                    Text(text = stringResource(R.string.aceptar))
                }
            },
            dismissButton = {
                TextButton(onClick = { onDismiss() }) {
                    Text(text = stringResource(R.string.no_aceptar))
                }
            },
            title = {
                Text(text = stringResource(R.string.advertencia))
            },
            text = {
                Text(
                    text = """La aplicación no se hace responsable de las posibles lesiones que pueda tener
                            ya que por su edad puede causarle daños fisicos que pueden traer serias consecuencias""" +
                            "\n¿Aún así desea ingresar a la aplicación?"
                )
            }
        )
    }
}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun WarningPopUpComponentPreview() {
//    WarningPopUpComponent()
//}