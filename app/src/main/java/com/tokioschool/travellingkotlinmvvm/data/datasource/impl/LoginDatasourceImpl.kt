package com.tokioschool.travellingkotlinmvvm.data.datasource.impl

import com.tokioschool.travellingkotlinmvvm.data.api.ApiLogin
import com.tokioschool.travellingkotlinmvvm.data.datasource.LoginDatasource
import com.tokioschool.travellingkotlinmvvm.data.response.UserResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LoginDatasourceImpl @Inject constructor(
    private val apiLogin:ApiLogin
): LoginDatasource {
    override fun logIn(user:String,pass:String): Flow<UserResponse> = flow {
        emit(apiLogin.logInUser(mapOf("usuario" to user,"password" to pass)))
    }


    override fun registerUser() {
        //Not yet implemented
    }

    override fun logOut() {
        //Not yet implemented
    }
}