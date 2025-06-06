package com.example.myapplication1


import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CalculadoraActivity : AppCompatActivity() {

    private lateinit var tvResult: TextView
    private var operando1 = ""
    private var operando2 = ""
    private var operador = ""
    private var enSegundoOperando = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)

        tvResult = findViewById(R.id.tv_result)

        val botonesNumeros = listOf(
            R.id.btn_0, R.id.btn_1, R.id.btn_2,
            R.id.btn_3, R.id.btn_4, R.id.btn_5,
            R.id.btn_6, R.id.btn_7, R.id.btn_8, R.id.btn_9
        )

        for (id in botonesNumeros) {
            findViewById<Button>(id).setOnClickListener {
                val valor = (it as Button).text.toString()
                if (enSegundoOperando) {
                    operando2 += valor
                    tvResult.text = operando2
                } else {
                    operando1 += valor
                    tvResult.text = operando1
                }
            }
        }

        findViewById<Button>(R.id.btn_plus).setOnClickListener { setOperador("+") }
        findViewById<Button>(R.id.btn_minus).setOnClickListener { setOperador("-") }
        findViewById<Button>(R.id.btn_multiply).setOnClickListener { setOperador("*") }
        findViewById<Button>(R.id.btn_divide).setOnClickListener { setOperador("/") }

        findViewById<Button>(R.id.btn_equal).setOnClickListener {
            val resultado = calcularResultado()
            tvResult.text = resultado
            operando1 = resultado
            operando2 = ""
            operador = ""
            enSegundoOperando = false
        }

        findViewById<Button>(R.id.btn_clear).setOnClickListener {
            operando1 = ""
            operando2 = ""
            operador = ""
            enSegundoOperando = false
            tvResult.text = "0"
        }
    }

    private fun setOperador(op: String) {
        if (operando1.isNotEmpty()) {
            operador = op
            enSegundoOperando = true
        }
    }

    private fun calcularResultado(): String {
        val num1 = operando1.toDoubleOrNull()
        val num2 = operando2.toDoubleOrNull()

        if (num1 == null || num2 == null) return "Error"

        return when (operador) {
            "+" -> (num1 + num2).toString()
            "-" -> (num1 - num2).toString()
            "*" -> (num1 * num2).toString()
            "/" -> if (num2 != 0.0) (num1 / num2).toString() else "Div / 0"
            else -> "Error"
        }
    }
}
