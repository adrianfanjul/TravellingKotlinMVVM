package com.tokioschool.travellingkotlinmvvm.presentation.features.home.fragments

import androidx.fragment.app.viewModels
import com.tokioschool.travellingkotlinmvvm.R
import com.tokioschool.travellingkotlinmvvm.core.base.BaseFragmentDb
import com.tokioschool.travellingkotlinmvvm.databinding.FragmentHomeBinding
import com.tokioschool.travellingkotlinmvvm.presentation.features.home.vm.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragmentDb<FragmentHomeBinding, HomeViewModel>() {

    override fun getLayout(): Int = R.layout.fragment_home
    override val viewModel: HomeViewModel by viewModels()

    override fun setBindingLayout() {
        dataBinding.viewModel = viewModel
    }


}

