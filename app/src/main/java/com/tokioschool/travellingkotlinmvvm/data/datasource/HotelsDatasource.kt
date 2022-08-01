package com.tokioschool.travellingkotlinmvvm.data.datasource

import com.tokioschool.travellingkotlinmvvm.data.response.HotelsResponse
import kotlinx.coroutines.flow.Flow

interface HotelsDatasource {
    fun getListHotels(): Flow<HotelsResponse>
}
