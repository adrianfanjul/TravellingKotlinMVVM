package com.tokioschool.travellingkotlinmvvm.presentation.features.login.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.material.snackbar.Snackbar
import com.tokioschool.travellingkotlinmvvm.databinding.FragmentLoginBinding
import com.tokioschool.travellingkotlinmvvm.presentation.features.login.vm.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private lateinit var dataBinding: FragmentLoginBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)
        dataBinding = FragmentLoginBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = this@LoginFragment
        }
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataBinding.viewModel=viewModel
        //viewModel.error.observe(viewLifecycleOwner,::viewStateError)
    }

    private fun viewStateError(throwable: Throwable){
        //Snackbar.make(dataBinding.loginUser,throwable?.message.toString(),Snackbar.LENGTH_LONG).show()
    }

}