package com.dignerdranch.anroid.sitkovdn_01_03

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.flat_bank)

        val etLogin = findViewById<EditText>(R.id.login_edittext)
        val etPassword = findViewById<EditText>(R.id.password_edittext)
        val btnLogin = findViewById<Button>(R.id.login_button)

        btnLogin.setOnClickListener {
            val login = etLogin.text.toString()
            val password = etPassword.text.toString()

            if(login == "admin" && password == "123"){
                startActivity(Intent(this,NextActivity::class.java))
            }else{
                Toast.makeText(this,"Неверный логин или пароль",Toast.LENGTH_LONG).show()
            }
        }
    }
}