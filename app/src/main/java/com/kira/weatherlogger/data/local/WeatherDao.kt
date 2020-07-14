package com.kira.weatherlogger.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface WeatherDao {
    @Query("SELECT * from weather_table")
    fun getAllWeather(): LiveData<List<WeatherData>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(weatherData: WeatherData)

    @Query("DELETE FROM weather_table")
    suspend fun deleteAll()
}