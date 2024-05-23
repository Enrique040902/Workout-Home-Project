package com.example.proyectofis.screens.pierna

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
import androidx.navigation.NavController
import com.example.proyectofis.R
import com.example.proyectofis.model.Rutina
import com.example.proyectofis.components.RutinaComponent
import com.example.proyectofis.navigation.AppScreens

@Composable
fun PiernaIntermedioScreen(navController: NavController) {

    val rutinas = listOf(
        Rutina(
            imageId = R.drawable.saltos_de_tijera,
            rutina = "Salto de tijera",
            reps = "30 segundos"
        ),
        Rutina(
            imageId = R.drawable.squats,
            rutina = "Squats",
            reps = "12 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.squats,
            rutina = "Squats",
            reps = "12 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.squats,
            rutina = "Squats",
            reps = "12 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.fire_hydrant_izq,
            rutina = "Fire hydrant izquierdo",
            reps = "12 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.fire_hydrant_der,
            rutina = "Fire hydrant derecho",
            reps = "12 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.fire_hydrant_izq,
            rutina = "Fire hydrant izquierdo",
            reps = "12 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.fire_hydrant_der,
            rutina = "Fire hydrant derecho",
            reps = "12 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.fire_hydrant_izq,
            rutina = "Fire hydrant izquierdo",
            reps = "12 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.fire_hydrant_der,
            rutina = "Fire hydrant derecho",
            reps = "12 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.zancada_frontal,
            rutina = "Zancada frontal",
            reps = "14 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.zancada_frontal,
            rutina = "Zancada frontal",
            reps = "14 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.circulos_pierna_izq,
            rutina = "Circulos con pierna izquierda",
            reps = "12 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.circulos_pierna_der,
            rutina = "Circulos con pierna derecha",
            reps = "12 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.circulos_pierna_izq,
            rutina = "Circulos con pierna izquierda",
            reps = "12 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.circulos_pierna_der,
            rutina = "Circulos con pierna derecha",
            reps = "12 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.sentadilla_sumo,
            rutina = "Sentadilla de sumo",
            reps = "12 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.sentadilla_sumo,
            rutina = "Sentadilla de sumo",
            reps = "12 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.sentadilla_sumo,
            rutina = "Sentadilla de sumo",
            reps = "12 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.levantamiento_de_pantorrilla,
            rutina = "Levantamiento de pantorrila con pared",
            reps = "12 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.levantamiento_de_pantorrilla,
            rutina = "Levantamiento de pantorrila con pared",
            reps = "12 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.levantamiento_de_pantorrilla,
            rutina = "Levantamiento de pantorrila con pared",
            reps = "12 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.pantorrilla_izq_salto,
            rutina = "Levantamiento de pantorrila izquierda con salto",
            reps = "12 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.pantorrilla_der_salto,
            rutina = "Levantamiento de pantorrila derecha con salto",
            reps = "12 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.pantorrilla_izq_salto,
            rutina = "Levantamiento de pantorrila izquierda con salto",
            reps = "12 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.pantorrilla_der_salto,
            rutina = "Levantamiento de pantorrila derecha con salto",
            reps = "12 repeticiones"
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
            text = stringResource(id = R.string.nivel_intermedio),
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
            text = stringResource(R.string.perdida_aprox_de_68_kcal),
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
fun PiernaIntermedioComponentPreview() {
//    PiernaIntermedioScreen()
}