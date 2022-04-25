package cbassdagreat.github.pruebakotlinv2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import cbassdagreat.github.pruebakotlinv2.databinding.ActivityMainBinding
import cbassdagreat.github.pruebakotlinv2.viewmodel.CryptoVM

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<CryptoVM>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getData()
    }
}