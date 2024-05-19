package ru.suslikkrol.weatherapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ru.suslikkrol.weatherapp.R
import ru.suslikkrol.weatherapp.databinding.ListItemBinding

class WeatherAdapter(val listener: Listener?) : ListAdapter<WeatherModel, WeatherAdapter.Holder>(Comporator()) {

    class Holder(view: View, val listener: Listener?) : RecyclerView.ViewHolder(view){
    val binding = ListItemBinding.bind(view)
    var itemTemp: WeatherModel? = null
        init {
            itemView.setOnClickListener{
                itemTemp?.let { it1 -> listener?.onClick(it1) }
            }
        }

    fun bind(item: WeatherModel) = with(binding) {
        itemTemp = item
        tvDataItem.text = item.time
        tvConditionItem.text = item.coindition
        tvTemp.text = item.currentTemp.ifEmpty { "${item.maxTemp}°C / ${item.mixTemp}°C" }
        Picasso.get().load("https" + item.imageUrl).into(im)
        }
    }

    class Comporator: DiffUtil.ItemCallback<WeatherModel>(){
        override fun areItemsTheSame(oldItem: WeatherModel, newItem: WeatherModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: WeatherModel, newItem: WeatherModel): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return Holder(view, listener)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
    }

    interface Listener{
        fun onClick(item: WeatherModel)
    }
}