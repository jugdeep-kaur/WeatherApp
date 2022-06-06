package com.example.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.weatherapp.api.RetroApiInterface
import com.example.weatherapp.api.WeatherRepository
import com.example.weatherapp.api.WeatherViewModel
import com.example.weatherapp.databinding.ActivityFrontPageBinding

class FrontPageActivity : AppCompatActivity() {
    lateinit var binding: ActivityFrontPageBinding
    lateinit var vm : WeatherViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFrontPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val api = RetroApiInterface.create()
        val repo = WeatherRepository(api)
        vm = WeatherViewModel(repo)
        vm.weather.observe(this) {
            println(it)
            binding.windyTextView.text = it.wind.gust.toString()
            binding.humidityTextView.text = it.main.humidity.toString()
            binding.tempTextView.text = it.main.temp.toString()
//            binding.cloudyText.text = it.cloud.all
            binding.LocationText.text = it.sys.country
        }
        vm.getWeather("35","139")
    }
}