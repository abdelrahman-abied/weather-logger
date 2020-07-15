package com.kira.weatherlogger.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kira.weatherlogger.viewmodel.ForecastRepository
import com.kira.weatherlogger.R
import com.kira.weatherlogger.adapters.RecyclerAdapter
import com.kira.weatherlogger.viewmodel.WeatherViewModel


class MainFragment : Fragment() {

    private lateinit var weatherViewModel: WeatherViewModel
    private val forecastRepository = ForecastRepository()
    var adapter: RecyclerAdapter? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        val view = inflater.inflate(R.layout.fragment_main, container, false)
        loadDataFromRoom(view)
        return view
    }

    private fun loadDataFromRoom(view: View) {


        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)

        weatherViewModel = ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory(activity!!.application)).get(WeatherViewModel::class.java)
        weatherViewModel.allWeatherData.observe(viewLifecycleOwner, Observer {


            adapter = RecyclerAdapter(activity, it)
            recyclerView?.adapter = adapter

        })


        val manager = LinearLayoutManager(context)
        manager.orientation = LinearLayoutManager.VERTICAL
        recyclerView?.layoutManager = manager
    }

}