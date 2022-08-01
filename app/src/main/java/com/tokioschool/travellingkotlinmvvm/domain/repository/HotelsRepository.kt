package com.tokioschool.travellingkotlinmvvm.domain.repository

import com.tokioschool.travellingkotlinmvvm.domain.models.Hotel
import kotlinx.coroutines.flow.Flow

interface HotelsRepository {
    fun getListHotels(): Flow<List<Hotel>>
}