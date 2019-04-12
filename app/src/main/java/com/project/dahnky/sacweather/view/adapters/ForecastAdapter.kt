package com.project.dahnky.sacweather.view.adapters

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.project.dahnky.sacweather.model.NWSForeHourlyPeriod
import com.project.dahnky.sacweather.view.custom.ForecastRowView

class ForecastAdapter(private val forecasts: List<NWSForeHourlyPeriod>) : RecyclerView.Adapter<ForecastAdapter.ForecastViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        return ForecastViewHolder(ForecastRowView(parent.context))
    }

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        holder.rowView.setup(forecast = forecasts[position])
    }

    override fun getItemCount(): Int = forecasts.size

    class ForecastViewHolder(val rowView: ForecastRowView) : RecyclerView.ViewHolder(rowView)
}
