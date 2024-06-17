package com.example.prueba1pme

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ActivityContratados2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // Establece el layout de la actividad
        setContentView(R.layout.activity_contratados2)

        // Referencias a los elementos desde el archivo XML segun su ID
        val ingresoBrutoEditText = findViewById<EditText>(R.id.ingresoBrutoEditText)
        val calcularButton = findViewById<Button>(R.id.calcularButton)
        val pagoNetoTextView = findViewById<TextView>(R.id.pagoNetoTextView)
        val volverButton = findViewById<Button>(R.id.volverButton)

        // Lógica del botón Calcular
        calcularButton.setOnClickListener {
            // Obtiene el valor ingresado en el EditText y lo convierte a Double, o asigna 0.0 si no es válido
            val ingresoBruto = ingresoBrutoEditText.text.toString().toDoubleOrNull() ?: 0.0
            // Crea un objeto EmpleadoRegular con el ingreso bruto proporcionado
            val empleado = EmpleadoRegular(ingresoBruto)
            // Calcula el pago líquido del empleado
            val pagoNeto = empleado.calcularLiquido()
            // Muestra el resultado en el TextView
            pagoNetoTextView.text = "Pago Liquido: $pagoNeto"
        }

        // Lógica del botón Volver
        volverButton.setOnClickListener {
            // Crea un Intent para volver a la actividad MainActivity
            val intent = Intent(this, MainActivity::class.java)
            // Inicia la actividad MainActivity
            startActivity(intent)
        }
    }
}
