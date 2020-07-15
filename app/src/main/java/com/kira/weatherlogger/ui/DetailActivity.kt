package com.kira.weatherlogger.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kira.weatherlogger.R

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        // Retrieve data coming from MainActivity.java
        val temp = intent.getStringExtra("temp")
        val max = intent.getStringExtra("max")
        val min = intent.getStringExtra("min")
        val date = intent.getStringExtra("date")

        // Pass the data to DetailsFragment to display it
        val detailsFragment = supportFragmentManager.findFragmentById(R.id.detailsFragment) as DetailsFragment?
        detailsFragment?.displayDetails(temp,max,min,date)

    }
}