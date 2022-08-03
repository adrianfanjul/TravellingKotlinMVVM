package com.tokioschool.travellingkotlinmvvm.presentation.features.login.fragments

import androidx.fragment.app.viewModels
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.tokioschool.travellingkotlinmvvm.R
import com.tokioschool.travellingkotlinmvvm.core.base.BaseFragmentDb
import com.tokioschool.travellingkotlinmvvm.core.extension.snack
import com.tokioschool.travellingkotlinmvvm.databinding.FragmentLoginBinding
import com.tokioschool.travellingkotlinmvvm.domain.models.SnackbarMessage
import com.tokioschool.travellingkotlinmvvm.domain.models.User
import com.tokioschool.travellingkotlinmvvm.presentation.features.login.vm.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragmentDb<FragmentLoginBinding, LoginViewModel>() {

    override fun getLayout(): Int = R.layout.fragment_login
    override val viewModel: LoginViewModel by viewModels()
    val callbackManager by lazy {CallbackManager.Factory.create()}
    val loginManager by lazy {LoginManager.getInstance()}

    override fun eventListeners() {
        dataBinding.loginFacebookBtn.setOnClickListener {initLogInFacebook()}
    }

    override fun setBindingLayout() {
        dataBinding.viewModel = viewModel
    }

    override fun observeViewModels() {
        viewModel.errorUser.observe(viewLifecycleOwner, ::errorUserName)
        viewModel.user.observe(viewLifecycleOwner, ::loginSucess)
    }

    override fun showError(message: String?) {
        snack(SnackbarMessage(R.string.error_facebook, varargs = message)).show()
    }

    private fun initLogInFacebook() {
        loginManager.logInWithReadPermissions(this,callbackManager,listOf("email", "public_profile"))
        loginManager.registerCallback(callbackManager, object :
            FacebookCallback<LoginResult> {
            override fun onSuccess(result: LoginResult) {
                viewModel.logInFacebook(result.accessToken)
            }

            override fun onCancel() {
                snack(SnackbarMessage(R.string.cancel_facebook)).show()
            }

            override fun onError(error: FacebookException) {
                snack(SnackbarMessage(R.string.error_facebook,varargs = error.message)).show()
            }
        })
    }

    private fun loginSucess(user: User?) {
        val directions = LoginFragmentDirections.loginFragmentToMainActivity(user)
        navigate(directions)
    }

    private fun errorUserName(isValid: Boolean?) {
        isValid?.let {
            when (isValid) {
                true -> dataBinding.loginInputLayoutUserName.error = getString(R.string.login_error_user)
                false -> dataBinding.loginInputLayoutUserName.error = null
            }
        }
    }


}

