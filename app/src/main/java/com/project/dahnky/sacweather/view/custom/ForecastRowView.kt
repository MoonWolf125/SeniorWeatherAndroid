package com.project.dahnky.sacweather.view.custom

import android.content.Context
import android.graphics.ColorFilter
import android.graphics.PorterDuff
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.FrameLayout
import com.bumptech.glide.Glide
import com.project.dahnky.sacweather.R
import com.project.dahnky.sacweather.model.NWSForeHourlyPeriod
import kotlinx.android.synthetic.main.view_forecast_row.view.*
import org.threeten.bp.ZoneId
import org.threeten.bp.ZonedDateTime
import org.threeten.bp.format.DateTimeFormatter
import org.threeten.bp.format.FormatStyle

class ForecastRowView @JvmOverloads constructor(context: Context,
                                                attrs: AttributeSet? = null,
                                                defStyleAttr: Int = 0) : FrameLayout(context, attrs, defStyleAttr) {
    init {
        if (attrs == null) {
            layoutParams = LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        }
        inflate(context, R.layout.view_forecast_row, this)
    }

    fun setup(forecast: NWSForeHourlyPeriod) {
        tv_title.text = ZonedDateTime.parse(forecast.startTime).format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).withZone(ZoneId.systemDefault()))
        tv_temperature.text = "${forecast.temperature}°"
        when {
            forecast.shortForecast!!.contains(SummaryIcon.SNOW.title) -> setIcon(SummaryIcon.SNOW)
            forecast.shortForecast.contains(SummaryIcon.RAIN.title) -> setIcon(SummaryIcon.RAIN)
            forecast.shortForecast.contains(SummaryIcon.SUN.title) -> setIcon(SummaryIcon.SUN)
            forecast.shortForecast.contains(SummaryIcon.CLOUD.title) -> setIcon(SummaryIcon.CLOUD)
            forecast.shortForecast.contains(SummaryIcon.CLEAR.title) -> setIcon(SummaryIcon.CLEAR)
        }
    }

    private fun setIcon(summaryIcon: SummaryIcon) {
        when (summaryIcon) {
            SummaryIcon.SNOW -> Glide.with(this).load(R.drawable.ic_snow).into(iv_forecast_icon)
            SummaryIcon.RAIN -> Glide.with(this).load(R.drawable.ic_cloudy_rain).into(iv_forecast_icon)
            SummaryIcon.SUN -> Glide.with(this).load(R.drawable.ic_clear_day).into(iv_forecast_icon)
            SummaryIcon.CLOUD -> Glide.with(this).load(R.drawable.ic_cloudy).into(iv_forecast_icon)
            SummaryIcon.CLEAR -> Glide.with(this).load(R.drawable.ic_clear_day).into(iv_forecast_icon)
        }

        iv_forecast_icon.setColorFilter(ContextCompat.getColor(context, R.color.msum_black), PorterDuff.Mode.SRC_ATOP)
    }
}
