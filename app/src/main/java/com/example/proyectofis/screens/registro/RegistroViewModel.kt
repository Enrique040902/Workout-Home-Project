package com.example.proyectofis.screens.registro

import android.util.Log
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.proyectofis.model.Usuario
import com.example.proyectofis.navigation.AppScreens
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.FirebaseFirestore

class RegistroViewModel : ViewModel() {

    private val auth: FirebaseAuth = Firebase.auth
    private val db = FirebaseFirestore.getInstance()

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _registroEnable = MutableLiveData<Boolean>()
    val registroEnable: LiveData<Boolean> = _registroEnable

    private fun createUserWithEmailAndPassword(
        email: String,
        password: String,
        principal: () -> Unit
    ) {
        try {
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener() { task ->
                    if (task.isSuccessful) {
                        val displayName = task.result.user?.email?.split("@")?.get(0)
                        createUser(displayName, email)
                        principal()
                    } else
                        Log.d("RegistroWh", "Usuario creado con exito: ${task.result}")
                }
        } catch (ex: Exception) {
            Log.d("RegistroWh", "createUerWithEmailAndPassword: ${ex.message}")
        }
    }

    private fun createUser(displayName: String?, email: String) {
        val userId = auth.currentUser?.uid

        val usuario = Usuario(
            id = userId.toString(),
            displayName = displayName.toString(),
            email = email
        ).toMap()

        if (userId != null) {
            db.collection("users")
                .document(userId)
                .set(usuario)
                .addOnSuccessListener {
                    Log.d("RegistroWh", "Creado $userId")
                }
                .addOnFailureListener {
                    Log.d("RegistroWh", "Ocurrio un error $it")
                }
        }
    }

    fun onRegisterChanged(email: String, password: String) {
        _email.value = email
        _password.value = password
        _registroEnable.value = isValidEmail(email) && isValidPassword(password)
    }

    private fun isValidEmail(email: String): Boolean =
        Patterns.EMAIL_ADDRESS.matcher(email).matches()

    private fun isValidPassword(password: String): Boolean = password.length >= 6
    fun onRegisterEnable(navController: NavController) {
        createUserWithEmailAndPassword(
            email = _email.value.toString(),
            password = _password.value.toString()
        ) {
            navController.navigate(AppScreens.PesoEstaturaScreen.route)
        }
    }
}