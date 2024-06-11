package com.example.proyectofis.screens

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class PrincipalViewModel : ViewModel() {

    private val db = FirebaseFirestore.getInstance()
    private val auth: FirebaseAuth = Firebase.auth

    var ejerciciosRealizados by mutableIntStateOf(0)
        private set

    var caloriasQuemadas by mutableDoubleStateOf(0.0)
        private set

    init {
        val user = auth.currentUser

        if (user != null) {
            val docRef =
                db.collection("users")
                    .document(user.uid)
                    .collection("Datos de los ejercicios")
                    .document("ejercicios")
            docRef.addSnapshotListener { snapshot, e ->
                if (e != null) {
                    Log.d("Principal", "Error: ${e.message}")
                } else if (snapshot != null && snapshot.exists()) {
                    ejerciciosRealizados = snapshot.getLong("ejercicios realizado")?.toInt() ?: 0
                    caloriasQuemadas = snapshot.getDouble("calorias quemadas") ?: 0.0
                    Log.d("Principal" , "ejercicios $ejerciciosRealizados  y  $caloriasQuemadas")
                }
            }
        }
    }

}