package com.tokioschool.travellingkotlinmvvm.presentation.features.home.fragments

import android.Manifest
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.material.snackbar.Snackbar
import com.tokioschool.travellingkotlinmvvm.R
import com.tokioschool.travellingkotlinmvvm.core.base.BaseFragmentDb
import com.tokioschool.travellingkotlinmvvm.core.extension.snack
import com.tokioschool.travellingkotlinmvvm.databinding.FragmentHotelMapsBinding
import com.tokioschool.travellingkotlinmvvm.domain.models.SnackbarMessage
import com.tokioschool.travellingkotlinmvvm.presentation.features.home.vm.HotelsMapsViewModel
import com.tokioschool.travellingkotlinmvvm.presentation.features.home.vm.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HotelMapsFragment : BaseFragmentDb<FragmentHotelMapsBinding, HotelsMapsViewModel>(), OnMapReadyCallback {

    val locationPermissionRequest = registerForActivityResult( ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
        when {
            permissions.getOrDefault(Manifest.permission.ACCESS_FINE_LOCATION, false) -> {
                // Precise location access granted.
                Log.e("adri", "tenemos permisos ACCESS_FINE_LOCATION")
            }
            permissions.getOrDefault(Manifest.permission.ACCESS_COARSE_LOCATION, false) -> {
                // Only approximate location access granted.
                Log.e("adri", "tenemos permisos ACCESS_COARSE_LOCATION")
            }
            else -> {
                // No location access granted.
                Log.e("adri", "no tenemos permisos")
                snack(SnackbarMessage(R.string.maps_no_permission))
                    .addCallback(object : Snackbar.Callback() {
                        override fun onDismissed(transientBottomBar: Snackbar?, event: Int) {
                            super.onDismissed(transientBottomBar, event)
                            navigateBack()
                        }
                    })
            }
        }
    }
    override val viewModel: HotelsMapsViewModel by viewModels()
    private val sharedViewModel: MainViewModel by activityViewModels()
    override fun getLayout(): Int = R.layout.fragment_hotel_maps

    override fun eventListeners() {
        initPermissions()
        initMaps()
    }

    private fun initPermissions() {
        locationPermissionRequest.launch(
            arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
        )
    }
    private fun initMaps(){
        (childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment).getMapAsync(this)
    }

    override fun onMapReady(map:GoogleMap){
        sharedViewModel.latLongMapHotel.observe(viewLifecycleOwner){ latLong ->
            Log.e("adri","entramos en el mapa")
            map.addMarker(latLong.second)
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(latLong.first,18f))
        }
    }
}