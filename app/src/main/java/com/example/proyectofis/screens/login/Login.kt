package com.example.proyectofis.screens.login

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
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
fun LoginScreen(viewModel: LoginViewModel, navController: NavController) {
    LoginComponent(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        viewModel = viewModel,
        navController = navController
    )
}

@Composable
fun LoginComponent(
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    navController: NavController
) {

    val email: String by viewModel.email.observeAsState(initial = "")
    val password: String by viewModel.password.observeAsState(initial = "")
    val loginEnable: Boolean by viewModel.loginEnable.observeAsState(initial = false)
    val passwordVisible = rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = modifier
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        HeaderLoginComponent()
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(38.dp))
            EmailLoginComponent(email = email) {
                viewModel.onLoginChanged(it, password)
            }
            Spacer(modifier = Modifier.height(16.dp))
            PasswordLoginComponent(password = password, passwordVisible = passwordVisible) {
                viewModel.onLoginChanged(email, it)
            }
            Spacer(modifier = Modifier.height(16.dp))
            ButtonLoginComponent(loginEnable = loginEnable) {
                viewModel.onLoginEnable(navController)
            }
            RegistroComponent(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                navController = navController
            )
        }
    }
}

@Composable
fun HeaderLoginComponent() {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            modifier = Modifier
                .size(120.dp),
            imageVector = Icons.Default.AccountCircle,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "Inicia sesión",
            style = TextStyle(
                fontSize = 36.sp,
                color = MaterialTheme.colorScheme.secondary
            )
        )
    }
}

@Composable
fun EmailLoginComponent(
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
                    color = Color.DarkGray
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
fun PasswordLoginComponent(
    password: String,
    passwordVisible: MutableState<Boolean>,
    onTextFieldChaged: (String) -> Unit
) {

    val visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation()

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth(),
        value = password,
        onValueChange = { onTextFieldChaged(it) },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        ),
        label = {
            Text(
                text = stringResource(R.string.ingrese_su_password),
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
        shape = RoundedCornerShape(8.dp),
        visualTransformation = visualTransformation,
        trailingIcon = {
            if (password.isNotBlank())
                PasswordVisibleIcon(passwordVisible = passwordVisible)
            else null
        }
    )
}

@Composable
fun ButtonLoginComponent(
    loginEnable: Boolean,
    onLoginSelected: () -> Unit
) {
    ElevatedButton(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        onClick = {
            onLoginSelected()
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        shape = RoundedCornerShape(10.dp),
        enabled = loginEnable
    ) {
        Text(
            text = "Iniciar sesión",
            style = TextStyle(
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.secondary,
                fontWeight = FontWeight.Bold
            )
        )
    }
}

@Composable
fun RegistroComponent(modifier: Modifier = Modifier, navController: NavController) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(R.string.no_tienes_cuenta),
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            )
            TextButton(
                onClick = {
                    navController.navigate(route = AppScreens.RegistroScreen.route)
                }
            ) {
                Text(
                    text = stringResource(R.string.registrate),
                    style = TextStyle(
                        fontWeight = FontWeight(600),
                        color = MaterialTheme.colorScheme.primary
                    )
                )
            }
        }
    }
}

//@Preview(
//    showSystemUi = true,
////    uiMode = Configuration.UI_MODE_NIGHT_YES
//)
//@Composable
//private fun LoginComponentPreview() {
//    PROYECTOFISTheme {
//        Surface(
//            modifier = Modifier.fillMaxSize(),
//            color = MaterialTheme.colorScheme.background
//        ) {
//           LoginScreen()
//        }
//    }
//}