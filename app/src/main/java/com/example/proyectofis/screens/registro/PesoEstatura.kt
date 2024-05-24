package com.example.proyectofis.screens.registro

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import com.example.proyectofis.R
import com.example.proyectofis.components.WarningPopUpComponent

@Composable
fun PesoEstaturaScreen(
    viewModel: PesoEstaturaViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    navController: NavController
) {
    PesoEstaturaComponent(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        viewModel = viewModel,
        navController = navController
    )
}

@Composable
fun PesoEstaturaComponent(
    modifier: Modifier = Modifier,
    viewModel: PesoEstaturaViewModel,
    navController: NavController
) {

    val estatura: String by viewModel.estatura.observeAsState(initial = "")
    val peso: String by viewModel.peso.observeAsState(initial = "")
    val edad: String by viewModel.edad.observeAsState(initial = "")
    val buttonEnable: Boolean by viewModel.buttonEnable.observeAsState(false)

    Column(
        modifier = modifier
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        HeaderPesoEstaturaComponent()
        Column(
            modifier = Modifier.fillMaxHeight()
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            EstaturaPesoEstaturaComponent(estatura = estatura) {
                viewModel.onRegisterChanged(estatura = it, peso = peso, edad = edad)
            }
            Spacer(modifier = Modifier.height(16.dp))
            PesoPesoEstaturaComponent(peso = peso) {
                viewModel.onRegisterChanged(estatura = estatura, peso = it, edad = edad)
            }
            Spacer(modifier = Modifier.height(16.dp))
            EdadPesoEstaturaComponent(edad = edad) {
                viewModel.onRegisterChanged(estatura = estatura, peso = peso, edad = it)
            }
            Spacer(modifier = Modifier.height(16.dp))
            ButtonPesoEstaturaComponent(buttonEnable = buttonEnable) {
                viewModel.onButtonEnable(navController)
            }
            WarningPopUpComponent(
                showPopUp = viewModel.showAlert.value,
                onDismiss = { viewModel.showAlert.value = false },
                onConfirm = {
                    viewModel.showAlert.value = false
                    viewModel.onConfirmDialog(navController)
                }
            )
        }
    }

}

@Composable
fun HeaderPesoEstaturaComponent() {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            modifier = Modifier
                .size(120.dp),
            imageVector = Icons.Default.CheckCircle,
            contentDescription = null,
            tint = colorResource(id = R.color.colorPrimary)
        )
        Text(
            text = stringResource(id = R.string.peso_estatura),
            style = TextStyle(
                fontSize = 36.sp,
                color = Color.DarkGray,
                textAlign = TextAlign.Center
            )
        )
    }
}

@Composable
fun EstaturaPesoEstaturaComponent(
    estatura: String,
    onTextFieldChanged: (String) -> Unit
) {
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth(),
        value = estatura,
        onValueChange = { onTextFieldChanged(it) },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
        ),
        label = {
            Text(
                text = stringResource(R.string.ingrese_su_estatura),
                color = Color.Gray,
                style = TextStyle(
                    fontSize = 16.sp,
                    color = Color.DarkGray
                )
            )
        },
        singleLine = true,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = colorResource(id = R.color.colorPrimary),
            unfocusedBorderColor = colorResource(id = R.color.colorPrimaryVariant)
        ),
        shape = RoundedCornerShape(8.dp)
    )
}

@Composable
fun PesoPesoEstaturaComponent(
    peso: String,
    onTextFieldChanged: (String) -> Unit
) {
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth(),
        value = peso,
        onValueChange = { onTextFieldChanged(it) },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
        ),
        label = {
            Text(
                text = stringResource(R.string.ingrese_su_peso),
                color = Color.Gray,
                style = TextStyle(
                    fontSize = 16.sp,
                    color = Color.DarkGray
                )
            )
        },
        singleLine = true,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = colorResource(id = R.color.colorPrimary),
            unfocusedBorderColor = colorResource(id = R.color.colorPrimaryVariant)
        ),
        shape = RoundedCornerShape(8.dp)
    )
}


@Composable
fun EdadPesoEstaturaComponent(
    edad: String,
    onTextFieldChanged: (String) -> Unit
) {
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth(),
        value = edad,
        onValueChange = { onTextFieldChanged(it) },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
        ),
        label = {
            Text(
                text = stringResource(R.string.ingrese_su_edad),
                color = Color.Gray,
                style = TextStyle(
                    fontSize = 16.sp,
                    color = Color.DarkGray
                )
            )
        },
        singleLine = true,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = colorResource(id = R.color.colorPrimary),
            unfocusedBorderColor = colorResource(id = R.color.colorPrimaryVariant)
        ),
        shape = RoundedCornerShape(8.dp)
    )
}

@Composable
fun ButtonPesoEstaturaComponent(
    buttonEnable: Boolean,
    onButtonSelected: () -> Unit
) {
    ElevatedButton(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        onClick = {
            onButtonSelected()
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(id = R.color.colorPrimary)
        ),
        shape = RoundedCornerShape(10.dp),
        enabled = buttonEnable
    ) {
        Text(
            text = "Listo",
            style = TextStyle(
                fontSize = 18.sp,
                color = colorResource(id = R.color.white),
                fontWeight = FontWeight.Bold
            )
        )
    }
}

@Preview(showSystemUi = true)
@Composable
private fun PesoEstaturaScreenPreview() {
//    PesoEstaturaScreen()
}