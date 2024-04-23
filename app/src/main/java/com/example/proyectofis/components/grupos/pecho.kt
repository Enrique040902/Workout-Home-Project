package com.example.proyectofis.components.grupos

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectofis.R

@Composable
private fun MenuComponent(){
    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        PechoComponent()
    }
}


@Composable
fun PechoComponent(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .shadow(
                elevation = 4.dp,
                shape = RoundedCornerShape(8.dp),
                spotColor = colorResource(id = R.color.colorPrimaryVariant)
            )
            .background(
                colorResource(id = R.color.lightColorPrimary),
                shape = RoundedCornerShape(8.dp)
            )
            .clickable { /* TODO */ },
        contentAlignment = Alignment.Center
    ) {
        ImagePechoComponent()

        Text(
            text = "Pecho",
            style = TextStyle(
                fontSize = 38.sp,
                color = Color.DarkGray,
            )
        )
    }
}

@Composable
private fun ImagePechoComponent() {
    Image(
        modifier = Modifier
            .fillMaxSize()
            .blur(2.dp)
            .padding(4.dp),
        contentScale = ContentScale.Crop,
        painter = painterResource(id = R.drawable.pecho),
        contentDescription = "Imagen de pecho",
        alpha = 0.8f
    )
}

@Preview
@Composable
private fun PechoComponentPreview() {
    PechoComponent()
}

@Preview(showSystemUi = true)
@Composable
private fun MenuComponentPreview(){
    MenuComponent()
}