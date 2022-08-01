package com.tokioschool.travellingkotlinmvvm.presentation.features.home.fragments

import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.tokioschool.travellingkotlinmvvm.R
import com.tokioschool.travellingkotlinmvvm.core.base.BaseFragmentDb
import com.tokioschool.travellingkotlinmvvm.core.base.recycler.BaseRvAdapter
import com.tokioschool.travellingkotlinmvvm.core.extension.snack
import com.tokioschool.travellingkotlinmvvm.databinding.FragmentHomeBinding
import com.tokioschool.travellingkotlinmvvm.domain.models.Hotel
import com.tokioschool.travellingkotlinmvvm.domain.models.SnackbarMessage
import com.tokioschool.travellingkotlinmvvm.presentation.features.home.vm.HomeViewModel
import com.tokioschool.travellingkotlinmvvm.presentation.features.home.vm.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragmentDb<FragmentHomeBinding, HomeViewModel>() {

    override val viewModel: HomeViewModel by viewModels()
    val sharedViewModel: MainViewModel by activityViewModels()
    override fun getLayout(): Int = R.layout.fragment_home
    private val adapter by lazy {
        BaseRvAdapter<Hotel>(R.layout.item_hotel_list) {hotel ->
            hotel?.let {
                sharedViewModel.setSelectedHotel(hotel)
                snack(SnackbarMessage(R.string.selected_hotel,it.name)).show()
            }
        }
    }

    override fun eventListeners() {
        dataBinding.homeRv.adapter=adapter
    }
    override fun initViewModels() {
        viewModel.loadHotelList()
    }

    override fun observeViewModels() {
        viewModel.hotelList.observe(viewLifecycleOwner){
            adapter.items = it
        }
    }

}

