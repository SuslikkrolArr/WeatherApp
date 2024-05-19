package ru.suslikkrol.weatherapp.adapters

data class WeatherModel(
    val city: String,
    val time: String,
    val coindition: String,
    val currentTemp: String,
    val maxTemp: String,
    val mixTemp: String,
    val imageUrl: String,
    val hours: String
)