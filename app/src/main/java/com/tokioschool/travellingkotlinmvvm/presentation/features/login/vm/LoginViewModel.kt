package com.tokioschool.travellingkotlinmvvm.presentation.features.login.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.tokioschool.travellingkotlinmvvm.core.base.BaseViewModel
import com.tokioschool.travellingkotlinmvvm.core.extension.isEmail
import com.tokioschool.travellingkotlinmvvm.domain.repository.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginRepository: LoginRepository
) : BaseViewModel() {

    val username = MutableLiveData("")
    val password = MutableLiveData("")

    val enableBtn:LiveData<Boolean> = Transformations.map(username){value ->
        return@map value.isEmail()
    }

    fun logIn(){
        //TODO LLAMAR REPOSITORY userName.value
    }

}