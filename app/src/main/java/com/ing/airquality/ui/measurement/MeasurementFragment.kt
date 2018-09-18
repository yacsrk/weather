package com.ing.airquality.ui.measurement

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ing.airquality.R
import com.ing.airquality.ui.component
import com.ing.airquality.ui.viewModelProvider
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.main_fragment.*
import java.text.SimpleDateFormat
import javax.inject.Inject

class MeasurementFragment : Fragment() {

    companion object {
        fun newInstance() = MeasurementFragment()
    }

    private val component by lazy {
        requireActivity()
                .application
                .component
                .airQualityComponent()
                .build()
    }
    private val viewModel by viewModelProvider { component.viewModel() }

    @Inject
    lateinit var picasso: Picasso
    @Inject
    lateinit var dateFormat: SimpleDateFormat

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onAttach(context: Context?) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.measurementLiveData.observe(this) {
            when (it) {
                is InitialState -> {
                    progressBar.visibility = View.GONE
                    weatherLayout.visibility = View.GONE
                }
                is Loading -> {
                    progressBar.visibility = View.VISIBLE
                    weatherLayout.visibility = View.GONE
                }
                is Error -> {
                    progressBar.visibility = View.GONE
                    weatherLayout.visibility = View.GONE
                    it.error
                }
                is Loaded -> {
                    progressBar.visibility = View.GONE
                    weatherLayout.visibility = View.VISIBLE
                    temperatureTextView.text = getString(R.string.temperature, it.value.currentTemperature)
                    cityTextView.text = it.value.city
                    dateTextView.text = dateFormat.format(it.value.measurementDate)
                    picasso.load(it.value.weatherIconUrl).into(weatherIconImageView)
                }
            }
        }
    }

}
