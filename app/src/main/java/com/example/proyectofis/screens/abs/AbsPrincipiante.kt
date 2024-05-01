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
import com.example.proyectofis.R
import com.example.proyectofis.Rutina
import com.example.proyectofis.components.RutinaComponent

@Composable
fun AbsPrincipianteComponent() {

    val rutinas = listOf(
        Rutina(
            imageId = R.drawable.saltos_de_tijera,
            rutina = "Saltos de tijera",
            reps = "30 seg"
        ),
        Rutina(
            imageId = R.drawable.principiante_crunch_abdominal,
            rutina = "Crunch abdomiales",
            reps = "10 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.principiante_twist_ruso,
            rutina = "Twist ruso",
            reps = "10 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.principinate_escalada_montania,
            rutina = "Escalada de montaña",
            reps = "10 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.principiante_toque_talon,
            rutina = "Toque al talón",
            reps = "10 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.principinate_elevacion_piernas,
            rutina = "Elevación de piernas",
            reps = "10 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.principiante_tablon,
            rutina = "Tablon",
            reps = "15 segundos"
        ),
        Rutina(
            imageId = R.drawable.principiante_crunch_abdominal,
            rutina = "Crunch abdominales",
            reps = "6 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.principiante_twist_ruso,
            rutina = "Twist ruso",
            reps = "6 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.principinate_escalada_montania,
            rutina = "Escalada de montaña",
            reps = "6 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.principiante_toque_talon,
            rutina = "Toque al talón",
            reps = "6 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.principinate_elevacion_piernas,
            rutina = "Elevación de piernas",
            reps = "6 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.principiante_tablon,
            rutina = "Tablón",
            reps = "10 segundos"
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
            text = stringResource(R.string.nivel_principiante),
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
            text = stringResource(R.string.perdida_aprox_pecho_principiante),
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
fun AbsPrincipianteComponentPreview() {
    AbsPrincipianteComponent()
}