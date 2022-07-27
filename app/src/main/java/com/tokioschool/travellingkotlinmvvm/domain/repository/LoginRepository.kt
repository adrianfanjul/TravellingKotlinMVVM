package com.tokioschool.travellingkotlinmvvm.domain.repository


import com.facebook.AccessToken
import com.tokioschool.travellingkotlinmvvm.domain.models.User
import kotlinx.coroutines.flow.Flow

interface LoginRepository {
    fun logIn(userName:String, password:String): Flow<User>
    fun logInFaceBook(token: AccessToken): Flow<User>
}