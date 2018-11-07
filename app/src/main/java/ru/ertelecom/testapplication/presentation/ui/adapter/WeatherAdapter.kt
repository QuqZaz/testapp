package ru.ertelecom.testapplication.presentation.ui.adapter

import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_weather.view.*
import ru.ertelecom.testapplication.R
import ru.ertelecom.testapplication.domain.model.WeatherItem
import ru.ertelecom.testapplication.presentation.GlideApp

class WeatherAdapter : ListAdapter<WeatherItem, WeatherAdapter.ViewHolder>(WeatherDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.item_weather, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        fun bind(item: WeatherItem) {
            itemView.tempTv.text = item.temp
            itemView.dateTv.text = item.date
            GlideApp.with(itemView.context)
                    .load(item.icon)
                    .into(itemView.icon)
        }
    }

    class WeatherDiffCallback : DiffUtil.ItemCallback<WeatherItem>() {
        override fun areItemsTheSame(oldItem: WeatherItem, newItem: WeatherItem): Boolean {
            return oldItem.date == newItem.date
        }

        override fun areContentsTheSame(oldItem: WeatherItem, newItem: WeatherItem): Boolean {
            return oldItem == newItem
        }
    }

}