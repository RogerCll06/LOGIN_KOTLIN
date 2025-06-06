package com.example.myapplication1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class LoginActivity:AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnLogin = findViewById<Button>(R.id.btnIniciar)
        val btnRegister = findViewById<Button>(R.id.btnRegistro)
        val btnImc = findViewById<Button>(R.id.btnGoogle)


        btnRegister.setOnClickListener {
            // Toast.makeText(this, "Mostrar pantalla registrar", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, RegistrarActivity::class.java))
        }
        btnLogin.setOnClickListener {
            // Toast.makeText(this, "Mostrar pantalla registrar", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, CalculadoraActivity::class.java))
        }
        btnImc.setOnClickListener {
            // Toast.makeText(this, "Mostrar pantalla registrar", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, CalculadoraIMCActivity::class.java))
        }


    }
}