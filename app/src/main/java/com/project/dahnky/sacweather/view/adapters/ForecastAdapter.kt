package com.project.dahnky.sacweather.view.adapters

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.project.dahnky.sacweather.model.NWSForecastPeriod
import com.project.dahnky.sacweather.view.custom.ForecastRowView
import com.project.dahnky.sacweather.view.custom.ForecastSelection

class ForecastAdapter(private val forecasts: List<NWSForecastPeriod>, private val forecastSelection: ForecastSelection) : RecyclerView.Adapter<ForecastAdapter.ForecastViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        return ForecastViewHolder(ForecastRowView(parent.context))
    }

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        holder.rowView.setup(forecast = forecasts[position], forecastSelection = forecastSelection)
    }

    override fun getItemCount(): Int = forecasts.size

    class ForecastViewHolder(val rowView: ForecastRowView) : RecyclerView.ViewHolder(rowView)
}
