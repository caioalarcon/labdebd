package com.example.formula1.ui.overview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.formula1.databinding.OverviewBinding

class OverviewActivity: AppCompatActivity() {
    private lateinit var binding: OverviewBinding
    //pegar o viewModel correspondente com o tipo de usuário logado

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = OverviewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        println("criado")
    }



}