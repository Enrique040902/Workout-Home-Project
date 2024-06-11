package com.example.proyectofis.screens.abs

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.proyectofis.model.Ejercicios
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import java.text.DecimalFormat

class AbsPrincipianteViewModel : ViewModel() {

    private val auth: FirebaseAuth = Firebase.auth
    private val db = FirebaseFirestore.getInstance()

    private var ejercicioRealizados = mutableStateOf(0)
    private var caloriasQuemadas = mutableStateOf(0.0)

    fun updateExerciseData(calories: Double) {
        val user = auth.currentUser
        if (user != null) {
            val docRef =
                db.collection("users")
                    .document(user.uid)
                    .collection("Datos de los ejercicios")
                    .document("ejercicios")

            ejercicioRealizados.value++
            caloriasQuemadas.value += calories

            val df = DecimalFormat("#.##")
            df.isDecimalSeparatorAlwaysShown = false
            val caloriasFormateadas = df.format(caloriasQuemadas.value)

            val ejercicios = mapOf(
                "ejercicios realizado" to ejercicioRealizados.value,
                "calorias quemadas" to caloriasFormateadas.toDouble()
            )

            Log.d("Abs", "datos ${ejercicioRealizados.value} - ${caloriasFormateadas.toDouble()}")

            docRef.set(ejercicios)
                .addOnSuccessListener {
                }
                .addOnFailureListener { e ->
                    // Handle failure, e.g., show an error message to the user
                    Log.d("AbsMenu", "Error ${e.message}")
                }
        }
    }
}