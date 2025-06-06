package com.example.myapplication1

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class CalculadoraIMCActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc)

        // Referencias a vistas kkkkkk
        val etPeso = findViewById<EditText>(R.id.etPeso)
        val spinnerAltura = findViewById<Spinner>(R.id.spinnerAltura)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)

        // Datos para el Spinner (alturas predefinidas)
        val alturas = arrayOf(
            "1.50 m", "1.55 m", "1.60 m", "1.65 m", "1.70 m",
            "1.75 m", "1.80 m", "1.85 m", "1.90 m", "160 cm",
            "165 cm", "170 cm", "175 cm", "180 cm", "185 cm",
            "190 cm"
        )

        // Adaptador para el Spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, alturas)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerAltura.adapter = adapter

        // Acción del botón Calcular
        btnCalcular.setOnClickListener {
            val pesoStr = etPeso.text.toString()
            val itemSeleccionado = spinnerAltura.selectedItem as String

            if (pesoStr.isEmpty()) {
                Toast.makeText(this, "Por favor ingresa tu peso", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val peso = pesoStr.toFloat()

            // Procesar altura según si está en metros o centímetros
            val alturaMetros = when {
                itemSeleccionado.contains("m") -> {
                    itemSeleccionado.replace(" m", "").toFloat()
                }
                itemSeleccionado.contains("cm") -> {
                    val cm = itemSeleccionado.replace(" cm", "").toFloat()
                    cm / 100 // convertir a metros
                }
                else -> 0f
            }

            if (alturaMetros <= 0) {
                Toast.makeText(this, "Altura inválida", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Cálculo del IMC
            val imc = peso / (alturaMetros * alturaMetros)
            val categoria = getCategoriaIMC(imc)
            val imcFormateado = String.format("%.2f", imc)

            // Mostrar resultado
            tvResultado.text = "Tu IMC es $imcFormateado\n$categoria"
        }
    }

    // Devuelve la categoría según el valor del IMC
    private fun getCategoriaIMC(imc: Float): String {
        return when {
            imc < 18.5 -> "Bajo peso"
            imc < 24.9 -> "Peso normal"
            imc < 29.9 -> "Sobrepeso"
            else -> "Obesidad"
        }
    }
}