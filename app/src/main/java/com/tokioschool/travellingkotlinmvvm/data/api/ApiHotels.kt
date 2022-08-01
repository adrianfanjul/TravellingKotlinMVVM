
package com.tokioschool.travellingkotlinmvvm.data.api

import com.tokioschool.travellingkotlinmvvm.data.response.HotelsResponse
import retrofit2.http.GET

interface ApiHotels {
    @GET("/listHotels")
    suspend fun getListHotels(): HotelsResponse
}