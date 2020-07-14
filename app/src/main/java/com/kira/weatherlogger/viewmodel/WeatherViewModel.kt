package com.kira.weatherlogger.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.kira.weatherlogger.data.local.WeatherData
import com.kira.weatherlogger.data.local.WeatherRepository
import com.kira.weatherlogger.data.local.WeatherRoomDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WeatherViewModel (application: Application) : AndroidViewModel(application)  {

    private val repository: WeatherRepository

    val allWeatherData: LiveData<List<WeatherData>>

    init {
        val weatherDao = WeatherRoomDatabase.getDatabase(application, viewModelScope).weatherDao()
        repository = WeatherRepository(weatherDao)
        allWeatherData = repository.allWeatherData
    }


    fun insert(weatherData: WeatherData) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(weatherData)
    }
    fun deleteAll()= viewModelScope.launch(Dispatchers.IO) {
        repository.deleteAll()
    }
}