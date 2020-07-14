package com.kira.weatherlogger.data.local

import androidx.lifecycle.LiveData

class WeatherRepository(private val weatherDao: WeatherDao) {

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    val allWeatherData: LiveData<List<WeatherData>> = weatherDao.getAllWeather()

    suspend fun insert(weatherData: WeatherData) {
        weatherDao.insert(weatherData)
    }
}