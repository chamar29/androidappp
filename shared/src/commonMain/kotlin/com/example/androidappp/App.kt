package com.example.androidappp

import androidappp.shared.generated.resources.Res
import androidappp.shared.generated.resources.auto1
import androidappp.shared.generated.resources.auto2
import androidappp.shared.generated.resources.logo_itj1
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import moe.tlaster.precompose.PreComposeApp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
@Preview
fun App() {
    PreComposeApp {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                // ---------- 1. LOGO EN CÍRCULO ----------
                Image(
                    painter = painterResource(Res.drawable.logo_itj1),
                    contentDescription = null,
                    modifier = Modifier
                        .size(200.dp)
                        .clip(CircleShape)
                        .background(Color.LightGray),
                    contentScale = ContentScale.Fit
                )

                // ---------- 2. CARD REUTILIZABLE ----------
                CardAuto(
                    imagen = Res.drawable.auto1,
                    marca = "Ford",
                    modelo = "Versa",
                    anio = 2022,
                    precio = 350000
                )

                CardAuto(
                    imagen = Res.drawable.auto2,
                    marca = "Nissan",
                    modelo = "Versa",
                    anio = 2022,
                    precio = 350000
                )
            }
        }
    }
}

// ---------- EL COMPONENTE REUTILIZABLE ----------
@Composable
fun CardAuto(
    imagen: DrawableResource,
    marca: String,
    modelo: String,
    anio: Int,
    precio: Int
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(170.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 15.dp),
        colors = CardDefaults.cardColors(containerColor = Color.LightGray)
    ) {
        Row {
            Image(
                painter = painterResource(imagen),
                contentDescription = null,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.White),
                contentScale = ContentScale.Fit
            )
            Column(
                modifier = Modifier
                    .weight(2f)
                    .fillMaxHeight()
                    .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .weight(3f)
                        .fillMaxWidth()
                ) {
                    Text(text = "Modelo: $modelo", fontSize = 18.sp)
                    Text(text = "Marca: $marca", fontSize = 18.sp)
                    Text(text = "Año: $anio", fontSize = 18.sp)
                    Text(text = "Precio: $precio MXN", fontSize = 18.sp)
                }
                Text(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .clickable {
                            println("Ver más de $marca $modelo")
                        },
                    text = "Ver más",
                    textAlign = TextAlign.End,
                    fontSize = 16.sp
                )
            }
        }
    }
}