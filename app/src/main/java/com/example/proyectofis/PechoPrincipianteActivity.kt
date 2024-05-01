package com.example.proyectofis

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.proyectofis.screens.pecho.PechoPrincipianteComponent
import com.example.proyectofis.ui.theme.PROYECTOFISTheme

class PechoPrincipianteActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PROYECTOFISTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PechoPrincipianteComponent()
                }
            }
        }

    }

    @Preview
    @Composable
    private fun PechoPrincipianteActivityPreview() {
        PROYECTOFISTheme {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                PechoPrincipianteComponent()
            }
        }
    }
}
