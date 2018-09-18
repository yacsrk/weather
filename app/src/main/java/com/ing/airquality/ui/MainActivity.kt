package com.ing.airquality.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ing.airquality.R
import com.ing.airquality.ui.measurement.MeasurementFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        supportActionBar?.elevation = 0f
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MeasurementFragment.newInstance())
                    .commitNow()
        }
    }

}
