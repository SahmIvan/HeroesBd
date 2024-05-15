package com.example.roomprojectapp.presentation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.roomprojectapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var btnMarvel: Button
    private lateinit var btnDC: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMarvel = findViewById(R.id.btnMarvel)
        btnMarvel.setOnClickListener {
            val selectedHouse = 0
            val intent = Intent(this, HomeActivity::class.java).apply {
                putExtra("casa", selectedHouse)
            }
            startActivity(intent)
        }

        btnDC = findViewById(R.id.btnDC)
        btnDC.setOnClickListener {
            val selectedHouse = 1
            val intent = Intent(this, HomeActivity::class.java).apply {
                putExtra("casa", selectedHouse)
            }
            startActivity(intent)
        }
    }
}