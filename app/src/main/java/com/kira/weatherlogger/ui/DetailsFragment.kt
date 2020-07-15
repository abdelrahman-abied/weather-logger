package com.kira.weatherlogger.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kira.weatherlogger.R
import com.kira.weatherlogger.utils.formatTempForDisplay
import kotlinx.android.synthetic.main.fragment_details.*
import java.text.SimpleDateFormat
import java.util.*


class DetailsFragment : Fragment() {

    @SuppressLint("SimpleDateFormat")
    private val DATE_FORMAT = SimpleDateFormat("MM-dd-yyyy")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_details, container, false)

        return view
    }

    @SuppressLint("SetTextI18n")
    fun displayDetails(day: String, max: String, min: String, date: String) {
        tempFText.text = "Temperature: " + formatTempForDisplay(day.toFloat())
        maxText.text = "Max Temperature: " + formatTempForDisplay(max.toFloat())
        minText.text = "Min Temperature: " + formatTempForDisplay(min.toFloat())
        dateFText.text = "Date: " + DATE_FORMAT.format(Date((date).toLong()))


    }


}