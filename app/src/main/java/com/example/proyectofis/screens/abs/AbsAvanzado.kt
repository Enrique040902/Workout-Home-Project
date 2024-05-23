package com.example.proyectofis.screens.abs

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

@Composable
fun AbsAvanzadoScreen(navController: NavController) {

    val rutinas = listOf(
        Rutina(
            imageId = R.drawable.saltos_de_tijera,
            rutina = "Saltos de tijera",
            reps = "30 seg"
        ),
        Rutina(
            imageId = R.drawable.abdominal,
            rutina = "Abdominal",
            reps = "20 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.puente_lateral,
            rutina = "Puente lateral derecho",
            reps = "20 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.puente_lateral,
            rutina = "Puente lateral izquierdo",
            reps = "20 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.principiante_crunch_abdominal,
            rutina = "Crunch abdominal",
            reps = "30 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.crunch_bicicleta,
            rutina = "Crunch de bicicleta",
            reps = "24 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.plancha_lado,
            rutina = "Plancha de lado derecho",
            reps = "20 segundos"
        ),
        Rutina(
            imageId = R.drawable.plancha_lado,
            rutina = "Plancha de lado derecho",
            reps = "20 segundos"
        ),
        Rutina(
            imageId = R.drawable.abdominal_v,
            rutina = "Abdominal en V",
            reps = "18 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.medio_flexion_rotacion,
            rutina = "Flexión y rotación",
            reps = "24 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.principiante_twist_ruso,
            rutina = "Twist ruso",
            reps = "48 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.principiante_crunch_abdominal,
            rutina = "Crunch abdominal",
            reps = "28 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.butt_bridge,
            rutina = "Butt bridge",
            reps = "30 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.principiante_toque_talon,
            rutina = "Toque al talón",
            reps = "34 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.abdominal_cruzado,
            rutina = "Abdominal cruzado",
            reps = "24 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.abdominal_v,
            rutina = "Abdominal en V",
            reps = "16 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.principiante_tablon,
            rutina = "Tablón",
            reps = "1 min"
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
            text = stringResource(R.string.nivel_avanzado),
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
            text = stringResource(R.string.perdida_aprox_pecho_avanzado),
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
fun AbsAvanzadoComponentPreview() {
//    AbsAvanzadoScreen()
}