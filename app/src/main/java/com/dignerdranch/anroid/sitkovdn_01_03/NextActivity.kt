package com.dignerdranch.anroid.sitkovdn_01_03

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

    class NextActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.raschet_stoimosti_kvartir)


            val ibButton = findViewById<ImageButton>(R.id.img_button)

            ibButton.setOnClickListener {
                startActivity(Intent(this, MainActivity::class.java))
            }

            val spinner: Spinner = findViewById(R.id.spinner)
            val etMetres: EditText = findViewById(R.id.metres)
            val btnResult: Button = findViewById(R.id.res_button)
            val resultTxt: TextView = findViewById(R.id.result_txt)

            val adapter = ArrayAdapter.createFromResource(
                this,
                R.array.apartments,
                android.R.layout.simple_spinner_item
            )
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter

            btnResult.setOnClickListener {
                val metresTxt = etMetres.text.toString()
                if(metresTxt.isEmpty()){
                    Toast.makeText(this, "Введите полщадь", Toast.LENGTH_LONG).show()
                }

                val metres = metresTxt.toDouble()
                val apartType = spinner.selectedItem.toString()

                val result = when (apartType){
                    "1 - комнатная" -> metres * 1100
                    "2 - комнатная" -> metres * 900
                    "3 - комнатная" -> metres * 800
                    "Студия" -> metres * 1100
                    else -> 0.0
                }

                resultTxt.text = "Результат: $result"
            }
        }
}