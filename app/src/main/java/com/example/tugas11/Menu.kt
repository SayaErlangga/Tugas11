package com.example.tugas11

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tugas11.databinding.ActivityMenuBinding

class Menu : AppCompatActivity() {
    private lateinit var binding : ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding){
            val MainActivity = Intent(this@Menu, MainActivity::class.java)
            val MainActivity2 = Intent(this@Menu, MainActivity2::class.java)

            btnAgent.setOnClickListener {
                startActivity(MainActivity)
            }
            btnMaps.setOnClickListener {
                startActivity(MainActivity2)
            }
        }
    }
}