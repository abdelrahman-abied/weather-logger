package com.kira.weatherlogger.ui

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.kira.weatherlogger.data.local.WeatherData

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.kira.weatherlogger.*
import com.kira.weatherlogger.navigator.AppNavigator
import com.kira.weatherlogger.viewmodel.ForecastRepository
import com.kira.weatherlogger.viewmodel.WeatherViewModel


class MainActivity : AppCompatActivity(), AppNavigator {

    private lateinit var weatherViewModel: WeatherViewModel
    private val forecastRepository = ForecastRepository()
    private var mIsDualPane = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        weatherViewModel = ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory(this.application))
                .get(WeatherViewModel::class.java)

        val fragmentDetailView = findViewById<View>(R.id.detailsFragment)
        mIsDualPane = fragmentDetailView?.visibility == View.VISIBLE
        //  loadDataFromRoom()
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.save_forecast -> {

                weatherViewModel.deleteAll()

                forecastRepository.loadWeatherForecast("b63fd2f93bb13c32f8a0a6d12f8ebe15")
                forecastRepository.weatherForecast.observe(this, Observer { it ->
                    it.daily.forEach {
                        val weatherData = WeatherData(temp = it.temp.day,
                                max = it.temp.max,
                                min = it.temp.min,
                                date = it.date.toString())

                        weatherViewModel.insert(weatherData)
////                       Log.d("T", "abdo : " + it.temp.day)
                    }


                })

                //        loadDataFromRoom()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun displayDetails(day: String, min: String, max: String, date: String) {
        if (mIsDualPane) { // If we are in Tablet
            val fragmentDetailView = supportFragmentManager.findFragmentById(R.id.detailsFragment) as DetailsFragment?
            fragmentDetailView?.displayDetails(day, max, min, date)
        } else { // When we are in Smart phone
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("temp", day)
            intent.putExtra("max", max)
            intent.putExtra("min", min)
            intent.putExtra("date", date)
            startActivity(intent)
        }

    }

}