package com.tokioschool.travellingkotlinmvvm.data.datasource

import com.tokioschool.travellingkotlinmvvm.data.response.UserResponse
import kotlinx.coroutines.flow.Flow

interface LoginDatasource {
    fun registerUser()
    fun logOut()
    fun logIn(user: String, pass: String): Flow<UserResponse>
}