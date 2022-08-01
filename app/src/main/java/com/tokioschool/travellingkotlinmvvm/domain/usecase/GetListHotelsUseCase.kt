package com.tokioschool.travellingkotlinmvvm.domain.usecase

import com.tokioschool.travellingkotlinmvvm.core.base.FlowUseCase
import com.tokioschool.travellingkotlinmvvm.core.di.domain.di.IoDispatcher
import com.tokioschool.travellingkotlinmvvm.domain.models.Hotel
import com.tokioschool.travellingkotlinmvvm.domain.repository.HotelsRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetListHotelsUseCase @Inject constructor(
    @IoDispatcher dispatcher: CoroutineDispatcher,
    private val hotelRespository: HotelsRepository
): FlowUseCase<Unit, List<Hotel>>(dispatcher) {


    override fun execute(params: Unit): Flow<List<Hotel>> {
        return hotelRespository.getListHotels()
    }
}