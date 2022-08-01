package com.tokioschool.travellingkotlinmvvm.data.repository


import com.tokioschool.travellingkotlinmvvm.data.mappers.maptoHotel
import com.tokioschool.travellingkotlinmvvm.data.datasource.HotelsDatasource
import com.tokioschool.travellingkotlinmvvm.domain.models.Hotel
import com.tokioschool.travellingkotlinmvvm.domain.repository.HotelsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class HotelsRepositoryImpl @Inject constructor(
    private val datasource: HotelsDatasource,
) : HotelsRepository {

    override fun getListHotels(): Flow<List<Hotel>> {
        return datasource.getListHotels()
            .map {
                it.maptoHotel()
            }
    }
}