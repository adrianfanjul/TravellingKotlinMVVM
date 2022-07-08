package com.tokioschool.travellingkotlinmvvm.domain.repository


import com.tokioschool.travellingkotlinmvvm.domain.models.User
import kotlinx.coroutines.flow.Flow

interface LoginRepository {
    fun logIn(userName:String, password:String): Flow<User>
    suspend fun logInFaceBook(token: String): User
}