package com.tokioschool.travellingkotlinmvvm.domain.usecase

import com.tokioschool.travellingkotlinmvvm.domain.core.base.FlowUseCase
import com.tokioschool.travellingkotlinmvvm.domain.core.di.IoDispatcher
import com.tokioschool.travellingkotlinmvvm.domain.repository.LoginRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

import javax.inject.Inject

class EjemploUseCase @Inject constructor(
    @IoDispatcher dispatcher: CoroutineDispatcher,
    private val userRepository: LoginRepository
) : FlowUseCase<String, String>(dispatcher) {

    override fun execute(params: String): Flow<String> {
        return flowOf("hola")
    }
}