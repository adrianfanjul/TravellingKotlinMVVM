package com.tokioschool.travellingkotlinmvvm.domain.usecase

import com.facebook.AccessToken
import com.tokioschool.travellingkotlinmvvm.domain.core.base.FlowUseCase
import com.tokioschool.travellingkotlinmvvm.domain.core.di.IoDispatcher
import com.tokioschool.travellingkotlinmvvm.domain.models.User
import com.tokioschool.travellingkotlinmvvm.domain.repository.LoginRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetLogInFacebookUseCase @Inject constructor(
    @IoDispatcher dispatcher: CoroutineDispatcher,
    private val loginRepository: LoginRepository
) : FlowUseCase<AccessToken, User>(dispatcher) {

    override fun execute(params: AccessToken): Flow<User> = loginRepository.logInFaceBook(params)

}