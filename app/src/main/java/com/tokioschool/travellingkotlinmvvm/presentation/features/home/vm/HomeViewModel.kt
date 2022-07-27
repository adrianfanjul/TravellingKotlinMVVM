package com.tokioschool.travellingkotlinmvvm.presentation.features.home.vm

import com.tokioschool.travellingkotlinmvvm.core.base.BaseViewModel
import com.tokioschool.travellingkotlinmvvm.domain.usecase.GetLogInUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getLogInUseCase: GetLogInUseCase,
) : BaseViewModel() {


}