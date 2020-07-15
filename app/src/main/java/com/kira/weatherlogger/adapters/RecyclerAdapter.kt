package com.kira.weatherlogger.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kira.weatherlogger.navigator.AppNavigator
import com.kira.weatherlogger.R
import com.kira.weatherlogger.data.local.WeatherData
import com.kira.weatherlogger.utils.formatTempForDisplay
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("SimpleDateFormat")
private val DATE_FORMAT = SimpleDateFormat("MM-dd-yyyy")

class RecyclerAdapter(private val context: Context?, private var list: List<WeatherData>) :
        RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = inflater.inflate(R.layout.list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val current = list[position]
        holder.setData(current, position)
        holder.setListeners()
    }

    override fun getItemCount(): Int = list.size

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var pos: Int = 0
        lateinit var current: WeatherData
        private val tempText: TextView = itemView.findViewById(R.id.tempText)
        private val dateText: TextView = itemView.findViewById(R.id.dateText)

        fun setData(current: WeatherData, position: Int) {
            tempText.text = "Temperature: " + formatTempForDisplay(current.temp)
//            dateText.text = "Date: "+ current.date
            Log.d("T", "abdo " + position + " " + current.date)
            dateText.text = "Date: " + DATE_FORMAT.format(Date((current.date).toLong()))
            this.pos = position
            this.current = current
        }

        fun setListeners() {

            itemView.setOnClickListener {
                val myCommunicator = context as AppNavigator
                myCommunicator.displayDetails(current.temp.toString(), current.min.toString(),
                        current.max.toString(), current.date)
            }
        }
    }
}