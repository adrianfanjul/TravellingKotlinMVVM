package com.tokioschool.travellingkotlinmvvm.presentation.features.home.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations.map
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.tokioschool.travellingkotlinmvvm.core.base.BaseViewModel
import com.tokioschool.travellingkotlinmvvm.domain.models.Hotel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : BaseViewModel() {
    private val _hotelSelected = MutableLiveData<Hotel>()

    val latLongMapHotel = map(_hotelSelected) {
        val latLong = LatLng(it.location.lat?: 0.0, it.location.long?: 0.0)
        latLong to MarkerOptions().position(latLong).title(it.name)
    }

    fun setSelectedHotel(hotel: Hotel) {
        _hotelSelected.value = hotel
    }
}