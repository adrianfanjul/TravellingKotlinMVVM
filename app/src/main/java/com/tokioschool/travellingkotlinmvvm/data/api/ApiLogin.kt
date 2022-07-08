package com.tokioschool.travellingkotlinmvvm.data.api

import com.tokioschool.travellingkotlinmvvm.data.response.UserResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiLogin {

    @POST("/login")
    suspend fun logInUser(
        @Body arguments: Map<String,String>
    ):UserResponse
}