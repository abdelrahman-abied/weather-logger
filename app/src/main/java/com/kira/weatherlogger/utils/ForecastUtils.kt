package com.kira.weatherlogger.utils

import android.content.Context
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

fun formatTempForDisplay(temp: Float): String {

    val temp = (temp - 32f) * (5f / 9f)
    return String.format("%.2f C°", temp)

}

fun showTempDisplayDialog(context: Context) {
    val dialogBuilder = AlertDialog.Builder(context)
            .setTitle("Choose Display Unit")
            .setMessage("Choose which temperature unit to use for temperature display")
            .setPositiveButton("F") { _, _ ->


            }
            .setNeutralButton("C") { _, _ ->

            }
            .setOnDismissListener {
                Toast.makeText(context, "all settings update after restart app", Toast.LENGTH_LONG)
                        .show()
            }
    dialogBuilder.show()
}
