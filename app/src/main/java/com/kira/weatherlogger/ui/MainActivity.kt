package com.kira.weatherlogger.ui

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kira.weatherforecast.api.WeeklyForecast
import com.kira.weatherlogger.ForecastRepository
import com.kira.weatherlogger.R
import com.kira.weatherlogger.adapters.RecyclerAdapter
import com.kira.weatherlogger.data.local.WeatherData

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.kira.weatherlogger.viewmodel.WeatherViewModel
import kotlinx.android.synthetic.main.activity_main.*

var adapter: RecyclerAdapter? = null

class MainActivity : AppCompatActivity() {
    private lateinit var weatherViewModel: WeatherViewModel
    private val forecastRepository = ForecastRepository()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        setupRecyclerView()
        loadDataFromRoom()
    }

//    private fun setupRecyclerView() {
//        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
//        val forecastViewModel: ForecastViewModel = ViewModelProvider(this).get(ForecastViewModel::class.java)
//        forecastViewModel.loadWeatherForecast("b63fd2f93bb13c32f8a0a6d12f8ebe15")
//        forecastViewModel.weatherForecast.observe(this, Observer { weeklyForecast ->
//
//            emptyText.visibility = View.GONE
//            progressBar.visibility = View.GONE
//            adapter = RecyclerAdapter(this, weeklyForecast.daily)
//            recyclerView.adapter = adapter
//
//        })
//
//
//        val manager = LinearLayoutManager(this)
//        manager.orientation = LinearLayoutManager.VERTICAL
//        recyclerView.layoutManager = manager
//    }

    private fun loadDataFromRoom() {
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)

        weatherViewModel = ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory(this!!.application)).get(WeatherViewModel::class.java)
        weatherViewModel.allWeatherData.observe(this, Observer {
            emptyText.visibility = View.GONE
            progressBar.visibility = View.GONE
            adapter = RecyclerAdapter(this, it)
            recyclerView.adapter = adapter
            it.forEach {
                Log.d("T", "abdo " + it.temp.toString())

            }
//            Log.d("T", "abdo " + it.get(0).temp.toString())
        })


        val manager = LinearLayoutManager(this)
        manager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = manager
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
                forecastRepository.weatherForecast.observe(this, Observer {it ->
                    it.daily.forEach {
                        val weatherData = WeatherData(temp = it.temp.day, date = it.date.toString())

                        weatherViewModel.insert(weatherData)
                        Log.d("T", "abdo : " + it.temp.day)
                    }
                    Log.d("T", "abdo : " + it.toString())

                })
                loadDataFromRoom()
                Toast.makeText(this, "done", Toast.LENGTH_LONG).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}