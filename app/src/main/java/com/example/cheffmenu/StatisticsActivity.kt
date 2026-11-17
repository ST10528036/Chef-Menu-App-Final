package com.example.cheffmenu

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import com.example.cheffmenu.R
import java.util.Locale

class StatisticsActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statistics)

        val items = MenuRepository.items

        findViewById<TextView>(R.id.totalCount).text =
            items.size.toString()

        findViewById<TextView>(R.id.starterCount).text =
            items.count { it.course == "Starter" }.toString()

        findViewById<TextView>(R.id.mainCount).text =
            items.count { it.course == "Main Course" }.toString()

        findViewById<TextView>(R.id.dessertCount).text =
            items.count { it.course == "Dessert" }.toString()

        val average = if (items.isEmpty()) 0.0
        else items.map { it.price }.average()

        findViewById<TextView>(R.id.averagePrice).text =
            "R" + String.format(Locale("en", "ZA"), "%.2f", average)

        findViewById<TextView>(R.id.backToMenu).setOnClickListener {
            finish()
        }
    }

    override fun onResume() {
        super.onResume()

        val items = MenuRepository.items

        findViewById<TextView>(R.id.totalCount).text =
            items.size.toString()

        findViewById<TextView>(R.id.starterCount).text =
            items.count { it.course == "Starter" }.toString()

        findViewById<TextView>(R.id.mainCount).text =
            items.count { it.course == "Main Course" }.toString()

        findViewById<TextView>(R.id.dessertCount).text =
            items.count { it.course == "Dessert" }.toString()

        val average = if (items.isEmpty()) 0.0
        else items.map { it.price }.average()

        findViewById<TextView>(R.id.averagePrice).text =
            "R" + String.format(Locale("en", "ZA"), "%.2f", average)
    }
}
