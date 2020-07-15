package com.kira.weatherlogger.navigator

interface AppNavigator {
    fun displayDetails(

                       day: String,
                       min: String,
                       max: String,
                       date: String
    )
}