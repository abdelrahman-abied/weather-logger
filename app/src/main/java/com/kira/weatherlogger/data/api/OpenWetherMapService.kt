package com.kira.weatherforecast.api

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

fun createOpenWeatherMapService(): OpenWetherMapService {
    val retrofit = Retrofit.Builder()
        .baseUrl("http://api.openweathermap.org")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
    return retrofit.create(OpenWetherMapService::class.java)
}


interface OpenWetherMapService {

    @GET("/data/2.5/onecall")
    fun sevenDayForecast(
            @Query("lat") lat: Float,
            @Query("lon") lon: Float,
            @Query("exclude") exclude: String,
            @Query("units") units: String,
            @Query("appid") apiKey: String
    ) : Call<WeeklyForecast>

}


