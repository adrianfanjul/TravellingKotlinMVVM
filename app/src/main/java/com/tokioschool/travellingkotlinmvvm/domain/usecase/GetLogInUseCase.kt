package com.tokioschool.travellingkotlinmvvm.domain.usecase

import com.tokioschool.travellingkotlinmvvm.domain.core.base.FlowUseCase
import com.tokioschool.travellingkotlinmvvm.domain.core.di.IoDispatcher
import com.tokioschool.travellingkotlinmvvm.domain.models.User
import com.tokioschool.travellingkotlinmvvm.domain.repository.LoginRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetLogInUseCase @Inject constructor(
    @IoDispatcher dispatcher: CoroutineDispatcher,
    private val loginRepository: LoginRepository
) : FlowUseCase<GetLogInUseCase.Params, User>(dispatcher) {

    override fun execute(params: Params): Flow<User> = loginRepository.logIn(params.userName,params.password)

    data class Params(val userName: String, val password: String)

}