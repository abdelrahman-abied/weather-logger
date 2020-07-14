package com.kira.weatherlogger

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kira.weatherforecast.api.WeeklyForecast
import com.kira.weatherforecast.api.createOpenWeatherMapService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ForecastRepository {
    private val weatherService = createOpenWeatherMapService()
    private var _weatherForecast: MutableLiveData<WeeklyForecast> = MutableLiveData()
    val weatherForecast: LiveData<WeeklyForecast> = _weatherForecast

    fun loadWeatherForecast(appid: String): LiveData<WeeklyForecast> {
        val call = weatherService.sevenDayForecast(
                lat = 33.441792F,
                lon = -94.037689F,
                apiKey = appid,
                exclude = "current,minutely,hourly",
                units = "imperial")


        call.enqueue(object : Callback<WeeklyForecast> {
            override fun onFailure(call: Call<WeeklyForecast>, t: Throwable) {
                Log.d("T", "abdo  response" + t.message.toString())
            }

            override fun onResponse(call: Call<WeeklyForecast>, response: Response<WeeklyForecast>) {
                Log.d("T", "abdo  response" + response.toString())
                _weatherForecast.value = response.body()           }
        })
        return weatherForecast
    }
}