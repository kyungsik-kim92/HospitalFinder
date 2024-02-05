package com.example.hospitalfinder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hospitalfinder.databinding.ActivityMainBinding
import net.daum.mf.map.api.MapView

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




    }
}