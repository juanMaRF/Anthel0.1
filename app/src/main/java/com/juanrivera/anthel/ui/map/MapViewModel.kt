package com.juanrivera.anthel.ui.map

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MapViewModel:ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "Aqui va el mapa"
    }
    val text: LiveData<String> = _text
}