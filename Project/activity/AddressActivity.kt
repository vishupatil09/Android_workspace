package com.example.apexfurniture.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.apexfurniture.R
import com.example.apexfurniture.databinding.ActivityAddressBinding
import com.example.apexfurniture.databinding.ActivityCartBinding

class AddressActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddressBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddressBinding.inflate(layoutInflater)
        val view = binding.root


    }
}