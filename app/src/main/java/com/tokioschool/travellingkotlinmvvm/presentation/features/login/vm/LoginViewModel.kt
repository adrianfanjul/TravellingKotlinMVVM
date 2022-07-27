package com.tokioschool.travellingkotlinmvvm.presentation.features.login.vm

import androidx.lifecycle.*
import com.facebook.AccessToken
import com.tokioschool.travellingkotlinmvvm.core.base.BaseViewModel
import com.tokioschool.travellingkotlinmvvm.core.base.SingleEvent
import com.tokioschool.travellingkotlinmvvm.core.extension.combine
import com.tokioschool.travellingkotlinmvvm.core.extension.isEmail
import com.tokioschool.travellingkotlinmvvm.core.extension.isValidPass
import com.tokioschool.travellingkotlinmvvm.domain.models.User
import com.tokioschool.travellingkotlinmvvm.domain.usecase.GetLogInFacebookUseCase
import com.tokioschool.travellingkotlinmvvm.domain.usecase.GetLogInUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val getLogInUseCase: GetLogInUseCase,
    private val getLogInFacebookUseCase: GetLogInFacebookUseCase,
) : BaseViewModel() {

    val userName = MutableLiveData("")
    val errorUser = liveData<Boolean> {
        emitSource(
            Transformations.map(enableBtn) {
                return@map it && userName.value?.isEmail() == false
            }
        )
    }
    val password = MutableLiveData("")
    val enableBtn: LiveData<Boolean> = userName.combine(password) { user, pass ->
        return@combine user.length > 3 && pass.isValidPass()
    }

    private val _user = MutableLiveData<User>()
    val user get() = _user

    fun logIn() {
        viewModelScope.launch {
            getLogInUseCase.execute(
                GetLogInUseCase.Params(
                    userName.value ?: "",
                    password.value ?: ""
                )
            )
                .onStart { _loading.value = true }
                .onCompletion { _loading.value = false }
                .catch { _error.value = SingleEvent(it) }
                .collect { _user.value= it }
        }
    }

    fun logInFacebook(accessToken: AccessToken) {
        viewModelScope.launch {
            getLogInFacebookUseCase.execute(accessToken)
                .onStart { _loading.value = true }
                .onCompletion { _loading.value = false }
                .catch { _error.value = SingleEvent(it) }
                .collect { _user.value= it }
        }
    }

}