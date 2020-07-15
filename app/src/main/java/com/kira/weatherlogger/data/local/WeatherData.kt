package com.kira.weatherlogger.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weather_table")
data class WeatherData(
        @PrimaryKey(autoGenerate = true) var id: Int = 0,
        @ColumnInfo(name = "temp") val temp: Float,
        @ColumnInfo(name = "max") val max: Float,
        @ColumnInfo(name = "min") val min: Float,
        @ColumnInfo(name = "date") val date: String
)