package com.tokioschool.travellingkotlinmvvm.data.mappers

import com.tokioschool.travellingkotlinmvvm.data.response.Address
import com.tokioschool.travellingkotlinmvvm.data.response.Coordinate
import com.tokioschool.travellingkotlinmvvm.data.response.HotelsResponse
import com.tokioschool.travellingkotlinmvvm.domain.models.AdressHotel
import com.tokioschool.travellingkotlinmvvm.domain.models.Hotel
import com.tokioschool.travellingkotlinmvvm.domain.models.Location


fun HotelsResponse.maptoHotel() =
    results?.map {
        Hotel(
            img = it?.optimizedThumbUrls?.srpDesktop?.split("?")?.get(0) ?: "",
            name = it?.name ?: "",
            adress = getAdress(it?.address),
            location = getLocation(it?.coordinate)
        )
    }.orEmpty()

fun getLocation(coordinate: Coordinate?): Location = Location(coordinate?.lat, coordinate?.lon)


fun getAdress(address: Address?): AdressHotel =
    AdressHotel(
        city = address?.locality ?: "",
        street = address?.streetAddress ?: "",
        postalCode = address?.postalCode ?: ""
    )

