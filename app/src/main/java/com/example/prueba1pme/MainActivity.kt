package com.example.prueba1pme

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.prueba1pme.ui.theme.Prueba1PMETheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            PantallaInicio()
            }
        }
    }

@Preview
@Composable
fun PantallaInicio(){
    val contexto = LocalContext.current
    //Columna para ordenar el contenido, ocupa toda la pantalla y centra su contenido verticalmente
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //Titulo de la pantalla
        Text("Calculadora de Remuneraciones")

        //Espacio vertical entre el titulo y los botones
        Spacer(modifier = Modifier.height(20.dp))

        //Boton para redirigir a la pantalla de calculo para empleados honorarios
        Button(onClick = {
            val intent = Intent(contexto, ActivityHonorarios()::class.java)
            contexto.startActivity(intent)
        }){
            Text("Empleado a Honorarios")
        }

        //Espacio entre botones
        Spacer(modifier = Modifier.height(20.dp))

        //Boton para redirigir a la pantalla de calculo para empleados contratados
        Button(onClick = {
            val intent = Intent(contexto, ActivityContratados2()::class.java)
            contexto.startActivity(intent)
        }){
            Text("Empleado a Contrata")
        }



    }
}

