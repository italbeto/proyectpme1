package com.example.prueba1pme

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.text.DecimalFormat

class ActivityHonorarios : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PantallaHonorarios()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PantallaHonorarios() {
    var ingresoBruto by remember { mutableStateOf("") } // Estado para almacenar el valor del ingreso bruto
    var pagoLiquido by remember { mutableStateOf("") } // Estado para almacenar el pago líquido calculado
    val contexto = LocalContext.current // Contexto local de la actividad
    val decimalFormat = DecimalFormat("#.#") // Formato decimal para mostrar solo un decimal

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Espaciador que ocupa todo el espacio disponible arriba
        Spacer(modifier = Modifier.weight(1f))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
    ) {
            OutlinedTextField(
                value = ingresoBruto,
                onValueChange = { ingresoBruto = it },
                label = { Text("Ingreso Bruto") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number // Teclado numérico para el campo de texto
                )
            )
            Button(
                onClick = {
                    val ingreso = ingresoBruto.toDoubleOrNull() ?: 0.0 // Convierte el ingreso bruto a Double
                    val empleado = EmpleadoHonorarios(ingreso) // Crea un objeto EmpleadoHonorarios
                    pagoLiquido = decimalFormat.format(empleado.calcularLiquido()) // Calcula y formatea el pago líquido
                },
                modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
            ) {
                Text("Calcular Pago Liquido")
            }
            if (pagoLiquido.isNotEmpty()) {
                Text("Pago Liquido: $pagoLiquido") // Muestra el resultado del cálculo
            }
        }

        Button(
            onClick = {
                val intent = Intent(contexto, MainActivity()::class.java) // Crea un Intent para volver a MainActivity
                contexto.startActivity(intent) // Inicia la actividad MainActivity
            },
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp)
        ) {
            Text("Volver a la pantalla principal")
        }
    }
}
