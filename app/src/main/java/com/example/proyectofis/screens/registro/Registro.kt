package com.example.proyectofis.screens.registro

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.proyectofis.R
import com.example.proyectofis.components.PasswordVisibleIcon
import com.example.proyectofis.navigation.AppScreens

@Composable
fun RegistroScreen(
    viewModel: RegistroViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    navController: NavController
) {
    RegistroComponent(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        viewModel = viewModel,
        navController = navController
    )
}

@Composable
fun RegistroComponent(
    modifier: Modifier = Modifier,
    viewModel: RegistroViewModel,
    navController: NavController
) {

    val email: String by viewModel.email.observeAsState(initial = "")
    val password: String by viewModel.password.observeAsState(initial = "")
    val registroEnable: Boolean by viewModel.registroEnable.observeAsState(initial = false)
    val passwordVisible = rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = modifier
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        HeaderRegistroComponent()
        Column(
            modifier = Modifier.fillMaxHeight()
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            EmailRegistroComponent(email = email) {
                viewModel.onRegisterChanged(it, password)
            }
            Spacer(modifier = Modifier.height(16.dp))
            PasswordRegitroComponent(password = password, passwordVisible = passwordVisible) {
                viewModel.onRegisterChanged(email, it)
            }
            Spacer(modifier = Modifier.height(16.dp))
            ButtonRegistroComponent(
                registroEnable = registroEnable,
                navController
            ) {
                viewModel.onRegisterEnable(navController)
            }
        }
    }

}

@Composable
fun HeaderRegistroComponent() {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            modifier = Modifier
                .size(120.dp),
            imageVector = Icons.Default.Person,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary
        )
        Text(
            text = stringResource(id = R.string.registrate2),
            style = TextStyle(
                fontSize = 36.sp,
                color = MaterialTheme.colorScheme.secondary
            )
        )
    }
}

@Composable
fun EmailRegistroComponent(
    email: String,
    onTextFieldChanged: (String) -> Unit
) {
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth(),
        value = email,
        onValueChange = { onTextFieldChanged(it) },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email
        ),
        label = {
            Text(
                text = stringResource(R.string.ingrese_su_email),
                color = Color.Gray,
                style = TextStyle(
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.secondary
                )
            )
        },
        singleLine = true,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = MaterialTheme.colorScheme.primary,
            unfocusedBorderColor = MaterialTheme.colorScheme.secondary
        ),
        shape = RoundedCornerShape(8.dp)
    )

}

@Composable
fun PasswordRegitroComponent(
    password: String,
    passwordVisible: MutableState<Boolean>,
    onTextFieldChanged: (String) -> Unit
) {

    val visualTransformation =
        if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation()

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth(),
        value = password,
        onValueChange = { onTextFieldChanged(it) },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        ),
        label = {
            Text(
                text = stringResource(R.string.ingrese_su_password),
                color = Color.Gray,
                style = TextStyle(
                    fontSize = 16.sp,
                    color = Color.DarkGray
                )
            )
        },
        singleLine = true,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = MaterialTheme.colorScheme.primary,
            unfocusedBorderColor = MaterialTheme.colorScheme.secondary
        ),
        shape = RoundedCornerShape(8.dp),
        visualTransformation = visualTransformation,
        trailingIcon = {
            if (password.isNotBlank())
                PasswordVisibleIcon(passwordVisible)
            else null
        }
    )
}


@Composable
fun ButtonRegistroComponent(
    registroEnable: Boolean,
    navController: NavController,
    onRegisterSelected: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        ElevatedButton(
            modifier = Modifier
                .fillMaxWidth(.5f)
                .padding(8.dp),
            onClick = {
                navController.popBackStack()
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.colorPrimary)
            ),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(
                text = "Atras",
                style = TextStyle(
                    fontSize = 18.sp,
                    color = colorResource(id = R.color.white),
                    fontWeight = FontWeight.Bold
                )
            )
        }
        ElevatedButton(
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(8.dp),
            onClick = {
                onRegisterSelected()
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.colorPrimary)
            ),
            shape = RoundedCornerShape(10.dp),
            enabled = registroEnable
        ) {
            Text(
                text = "Siguiente",
                style = TextStyle(
                    fontSize = 18.sp,
                    color = colorResource(id = R.color.white),
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
}

//@Preview(showSystemUi = true)
//@Composable
//private fun RegistroScreenPreview() {
//    RegistroScreen()
//}