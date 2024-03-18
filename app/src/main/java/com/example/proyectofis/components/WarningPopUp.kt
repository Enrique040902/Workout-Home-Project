package com.example.proyectofis.components

import android.app.ProgressDialog.show
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
                    text = """
                    La aplicación no se hace resposable de las posibles lesiones que pueda tener
                    ya que por su edad puede causar le daños fisicos que pueden traer seria consecuencias
                    
                    ¿Aún así desea ingresar?
                """.trimMargin()
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