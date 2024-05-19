package ru.suslikkrol.weatherapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.suslikkrol.weatherapp.adapters.WeatherModel

class MainViewModel : ViewModel() {
    val liveDataCurrent = MutableLiveData<WeatherModel>()
    val liveDataList = MutableLiveData<List<WeatherModel>>()
}