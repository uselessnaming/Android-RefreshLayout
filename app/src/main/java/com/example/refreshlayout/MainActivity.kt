package com.example.refreshlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.refreshlayout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    var refreshCount = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.contentSrl.setOnRefreshListener {
            onStart()
            binding.contentSrl.isRefreshing = false
        }
    }
    override fun onStart(){
        super.onStart()
        refreshCount = if (refreshCount != 0) refreshCount + 1 else 1
        binding.tvCount.setText(refreshCount.toString())
    }
}