package com.tokioschool.travellingkotlinmvvm.data.datasource.impl

import com.tokioschool.travellingkotlinmvvm.data.api.ApiHotels
import com.tokioschool.travellingkotlinmvvm.data.datasource.HotelsDatasource
import com.tokioschool.travellingkotlinmvvm.data.response.HotelsResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class HotelsDatasourceImpl @Inject constructor(
    private val apiHotels: ApiHotels
): HotelsDatasource {

    override fun getListHotels(): Flow<HotelsResponse> = flow {
        emit(apiHotels.getListHotels())
    }

}
