package com.tokioschool.travellingkotlinmvvm.presentation.features.home.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.tokioschool.travellingkotlinmvvm.core.base.BaseViewModel
import com.tokioschool.travellingkotlinmvvm.core.base.SingleEvent
import com.tokioschool.travellingkotlinmvvm.domain.models.Hotel
import com.tokioschool.travellingkotlinmvvm.domain.usecase.GetListHotelsUseCase
import com.tokioschool.travellingkotlinmvvm.domain.usecase.GetLogInUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val hotelListUseCase: GetListHotelsUseCase,
) : BaseViewModel() {

    private val _hotelList = MutableLiveData<List<Hotel>>()
    val hotelList: LiveData<List<Hotel>> get() = _hotelList

    fun loadHotelList() {
        viewModelScope.launch {
            hotelListUseCase.execute(Unit)
                .onStart { _loading.value = true }
                .onCompletion { _loading.value = false }
                .catch { _error.value = SingleEvent(it) }
                .collect { _hotelList.value = it }
        }
    }
}