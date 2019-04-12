package com.project.dahnky.sacweather.view.nav.home

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.project.dahnky.sacweather.R
import com.project.dahnky.sacweather.core.CoreFragment
import com.project.dahnky.sacweather.model.NWSForeHourlyPeriod
import com.project.dahnky.sacweather.view.adapters.ForecastAdapter
import com.project.dahnky.sacweather.view.custom.SummaryIcon
import com.project.dahnky.sacweather.view.custom.drawer.DrawerViewListener
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.content_home.*
import kotlinx.android.synthetic.main.content_temperature_detail.*
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : CoreFragment<HomePresenter>(), IHomeView {

    private lateinit var listener: DrawerViewListener

    companion object {
        fun newInstance(listener: DrawerViewListener) = HomeFragment().apply {
            this.listener = listener
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.start()
        swipe_refresh.setOnRefreshListener { presenter.refresh() }
        rv_forecasts.layoutManager = LinearLayoutManager(activity)
    }

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun showProgress() {
        swipe_refresh.isRefreshing = true
    }

    override fun hideProgress() {
        swipe_refresh.isRefreshing = false
    }
    override fun setLocation(city: String, state: String) {
        listener.setToolbarTitle("$city, $state")
    }

    override fun setDate(dateString: String) {
        tv_date.text = dateString
    }

    override fun setCurrentForecast(forecast: NWSForeHourlyPeriod?) {
        if (forecast != null) {
            if (forecast.temperature >= 0) {
                tv_negative.visibility = View.GONE
                tv_temperature.text = "${forecast.temperature}"
            } else {
                tv_negative.visibility = View.VISIBLE
                tv_temperature.text = "${forecast.temperature * -1}"
            }
            tv_degree.visibility = View.VISIBLE
            tv_summary.text = forecast.shortForecast
            tv_wind.text = "${forecast.windSpeed} ${forecast.windDirection}"
        }
    }

    override fun setHourlyForecasts(forecasts: List<NWSForeHourlyPeriod>): Boolean {
        rv_forecasts.adapter = ForecastAdapter(forecasts)
        return true
    }

    override fun setSummaryIcon(summaryIcon: SummaryIcon) {
        when (summaryIcon) {
            SummaryIcon.SNOW -> Glide.with(this).load(R.drawable.ic_snow).into(iv_summary_icon)
            SummaryIcon.RAIN -> Glide.with(this).load(R.drawable.ic_cloudy_rain).into(iv_summary_icon)
            SummaryIcon.SUN -> Glide.with(this).load(R.drawable.ic_clear_day).into(iv_summary_icon)
            SummaryIcon.CLOUD -> Glide.with(this).load(R.drawable.ic_cloudy).into(iv_summary_icon)
            SummaryIcon.CLEAR -> Glide.with(this).load(R.drawable.ic_clear_day).into(iv_summary_icon)
        }
    }
}