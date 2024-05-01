package com.example.proyectofis.screens.brazo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectofis.R
import com.example.proyectofis.Rutina
import com.example.proyectofis.components.RutinaComponent

@Composable
fun BrazoPrincipianteComponent() {

    val rutinas = listOf(
        Rutina(
            imageId = R.drawable.principiante_elevacion_brazos,
            rutina = "Elevaciones de brazos",
            reps = "30 seg"
        ),
        Rutina(
            imageId = R.drawable.principiante_elevacion_lateral_brazos,
            rutina = "Elevaciones laterales de brazos",
            reps = "10 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.principiante_flexiones_triceps_con_silla,
            rutina = "Triceps con silla",
            reps = "10 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.principiante_circulo_brazos,
            rutina = "Circulos con los brazos",
            reps = "10 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.principiante_circulo_brazos,
            rutina = "Circulos con los brazos en sentido inverso",
            reps = "10 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.principiante_flexiones_diamante,
            rutina = "Flexiones en diamante",
            reps = "8 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.saltos_de_tijera,
            rutina = "Salto de tijera",
            reps = "30 segundos"
        ),
        Rutina(
            imageId = R.drawable.principiante_plancha_diagonal,
            rutina = "Plancha diagonal",
            reps = "10 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.principiante_punietazos,
            rutina = "Puñetazos",
            reps = "20 segundos"
        ),
        Rutina(
            imageId = R.drawable.flexiones_simples,
            rutina = "Flexiones simples",
            reps = "10 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.inchworms,
            rutina = "Inchworms",
            reps = "8 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.flexiones_en_pared,
            rutina = "Flexiones en la pared",
            reps = "10 repeticiones"
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            text = stringResource(id = R.string.nivel_principiante),
            style = TextStyle(
                fontSize = 30.sp,
                textAlign = TextAlign.Center
            )
        )
        Text(
            modifier = Modifier
                .padding(
                    start = 8.dp
                ),
            text = stringResource(R.string.perdida_aprox_de_64_kcal),
            style = TextStyle(
                fontSize = 14.sp,
                color = Color.Gray
            )
        )
        LazyColumn(
            modifier = Modifier
                .padding(8.dp)
        ) {
            items(rutinas) {rutina ->
                RutinaComponent(
                    imageId = rutina.imageId,
                    rutina = rutina.rutina,
                    reps = rutina.reps
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun BrazoPrincipianteComponentPreview() {
    BrazoPrincipianteComponent()
}