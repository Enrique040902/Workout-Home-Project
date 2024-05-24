package com.example.proyectofis.screens.registro

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.proyectofis.components.WarningPopUpComponent
import com.example.proyectofis.model.UsuarioPEE
import com.example.proyectofis.navigation.AppScreens
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.launch

class PesoEstaturaViewModel : ViewModel() {

    private val auth: FirebaseAuth = Firebase.auth
    private val db = FirebaseFirestore.getInstance()

    private val _estatura = MutableLiveData<String>()
    val estatura: LiveData<String> = _estatura

    private val _peso = MutableLiveData<String>()
    val peso: LiveData<String> = _peso

    private val _edad = MutableLiveData<String>()
    val edad: LiveData<String> = _edad

    private val _buttonEnable = MutableLiveData<Boolean>()
    val buttonEnable: LiveData<Boolean> = _buttonEnable

//    private val _showPopUpWarning = MutableLiveData<Boolean>()
//    val showPopUpWarning: LiveData<Boolean> = _showPopUpWarning

    var showAlert = mutableStateOf(false)

    fun onRegisterChanged(
        estatura: String,
        peso: String,
        edad: String
    ) {
        _estatura.value = estatura
        _peso.value = peso
        _edad.value = edad
        _buttonEnable.value = isValid(estatura, peso)
    }

    fun onButtonEnable(navController: NavController) {
        if (isSenior()) {
            Log.d("PE", "${showAlert.value} Edad: ${_edad.value}")
            showAlert.value = true
        }
        else {
            saveDataAndNavigate(navController)
        }
    }

    private fun isSenior(): Boolean {
        return (_edad.value?.toIntOrNull() ?: 0) >= 60
    }

    fun onConfirmDialog(navController: NavController) {
        saveDataAndNavigate(navController)
    }

    private fun saveDataAndNavigate(navController: NavController) {
        saveData(
            estatura = _estatura.value.toString(),
            peso = _peso.value.toString(),
            edad = _edad.value.toString()
        ) {
            navController.navigate(AppScreens.PrincipalScreen.route)
        }
    }

    private fun saveData(estatura: String, peso: String, edad: String, principal: () -> Unit) =
        viewModelScope.launch {
            val userId = auth.currentUser?.uid
            val datosUsuario = UsuarioPEE(
                peso = peso,
                edad = edad,
                estatura = estatura
            ).toMap()
            if (userId != null) {
                db.collection("users")
                    .document(userId)
                    .update(datosUsuario)
                    .addOnSuccessListener { Log.d("RegistroWh", "Datos guardados correctamente") }
                    .addOnFailureListener {
                        Log.d(
                            "RegistroWhd",
                            "Los datos no se pudieron guardas"
                        )
                    }
                principal()
            }
        }

    private fun isValid(
        estatura: String,
        peso: String
    ): Boolean = estatura.isNotBlank() && peso.isNotBlank()
}