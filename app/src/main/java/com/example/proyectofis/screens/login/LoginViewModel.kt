package com.example.proyectofis.screens.login

import android.util.Log
import android.util.Patterns
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.proyectofis.navigation.AppScreens
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.auth
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    private val auth: FirebaseAuth = Firebase.auth

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _loginEnable = MutableLiveData<Boolean>()
    val loginEnable: LiveData<Boolean> = _loginEnable

//    Función para realizar el login con Firabase
    private fun signWithEmailAndPassword (
        email: String,
        password: String,
        principal: () -> Unit
    ) = viewModelScope.launch {
        try {
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener {task ->
                    if (task.isSuccessful) {
                        Log.d("LoginWH", "signWithEmailAndPassword: logeado")
                        principal()
                    } else {
                        val error = (task.exception as FirebaseAuthException).errorCode
                        darToastError(error)
                    }
                }
        } catch (ex: Exception) {
            Log.d("LoginWH", "signWithEmailAndPassword: ${ex.message}")
        }
}

    fun onLoginChanged(
        email: String,
        password: String
    ) {
        _email.value = email
        _password.value = password
        _loginEnable.value = isValidEmail(email) && isValidPassword(password)
    }

    private fun isValidEmail(email: String): Boolean =
        Patterns.EMAIL_ADDRESS.matcher(email).matches()

    private fun isValidPassword(password: String): Boolean = password.length >= 6


    fun onLoginEnable(navController: NavController) {
        signWithEmailAndPassword(email = _email.value.toString(), password = _password.value.toString()) {
            navController.navigate(AppScreens.PrincipalScreen.route)
        }
    }

    private fun darToastError(error: String) {
        when (error) {
            "ERROR_INVALID_CUSTOM_TOKEN" -> Toast.makeText(
                null,
                "El formato del token es inrrecto. Por favor revise la documentación",
                Toast.LENGTH_LONG
            ).show()

            "ERROR_CUSTOM_TOKEN_MISMATCH" -> Toast.makeText(
                null,
                "El token personalizado corresponde a una audiencia diferente.",
                Toast.LENGTH_LONG
            ).show()

            "ERROR_INVALID_CREDENTIAL" -> Toast.makeText(
                null,
                "La credencial de autenticación proporcionada tiene un formato incorrecto o ha caducado",
                Toast.LENGTH_LONG
            ).show()

            "ERROR_INVALID_EMAIL" -> {
                Toast.makeText(
                    null,
                    "La dirección de correo electronio está mal formateada",
                    Toast.LENGTH_LONG
                ).show()
            }

            "ERROR_WRONG_PASSWORD" -> {
                Toast.makeText(
                    null,
                    "la constraseña no es valida o el usuario no tiene constraseña",
                    Toast.LENGTH_LONG
                ).show()
            }

            "ERROR_USER_MISMATCH" -> Toast.makeText(
                null,
                "Las credenciales proporcionadas no corresponden al usuario que inició sesión anteriormente..",
                Toast.LENGTH_LONG
            ).show()

            "ERROR_REQUIRES_RECENT_LOGIN" -> Toast.makeText(
                null,
                "Esta operación es sensible y requiere autenticación reciente. Inicie sesión nuevamente antes de volver a intentar esta solicitud.",
                Toast.LENGTH_LONG
            ).show()

            "ERROR_ACCOUNT_EXISTS_WITH_DIFFERENT_CREDENTIAL" -> Toast.makeText(
                null,
                "Ya existe una cuenta con la misma dirección de correo electrónico pero diferentes credenciales de inicio de sesión. Inicie sesión con un proveedor asociado a esta dirección de correo electrónico.",
                Toast.LENGTH_LONG
            ).show()

            "ERROR_EMAIL_ALREADY_IN_USE" -> {
                Toast.makeText(
                    null,
                    "La dirección de correo electrónico ya está siendo utilizada por otra cuenta..   ",
                    Toast.LENGTH_LONG
                ).show()
            }

            "ERROR_CREDENTIAL_ALREADY_IN_USE" -> Toast.makeText(
                null,
                "Esta credencial ya está asociada con una cuenta de usuario diferente.",
                Toast.LENGTH_LONG
            ).show()

            "ERROR_USER_DISABLED" -> Toast.makeText(
                null,
                "La cuenta de usuario ha sido inhabilitada por un administrador..",
                Toast.LENGTH_LONG
            ).show()

            "ERROR_USER_TOKEN_EXPIRED" -> Toast.makeText(
                null,
                "La credencial del usuario ya no es válida. El usuario debe iniciar sesión nuevamente.",
                Toast.LENGTH_LONG
            ).show()

            "ERROR_USER_NOT_FOUND" -> Toast.makeText(
                null,
                "No hay ningún registro de usuario que corresponda a este identificador. Es posible que se haya eliminado al usuario.",
                Toast.LENGTH_LONG
            ).show()

            "ERROR_INVALID_USER_TOKEN" -> Toast.makeText(
                null,
                "La credencial del usuario ya no es válida, el usuario debe iniciar sesión nuevamente.",
                Toast.LENGTH_LONG
            ).show()

            "ERROR_OPERATION_NOT_ALLOWED" -> Toast.makeText(
                null,
                "Esta operación no está permitida. Debes habilitar este servicio en la consola.",
                Toast.LENGTH_LONG
            ).show()

            "ERROR_WEAK_PASSWORD" -> {
                Toast.makeText(
                    null,
                    "La contraseña proporcionada no es válida..",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

}