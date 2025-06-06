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

        btnRegister.setOnClickListener {
            // Toast.makeText(this, "Mostrar pantalla registrar", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, RegistrarActivity::class.java))
        }


    }
}