package com.tokioschool.travellingkotlinmvvm.presentation.features.home.vm

import android.Manifest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.viewModelScope
import com.tokioschool.travellingkotlinmvvm.core.base.BaseViewModel
import com.tokioschool.travellingkotlinmvvm.core.base.SingleEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HotelsMapsViewModel @Inject constructor(

): BaseViewModel() {



}