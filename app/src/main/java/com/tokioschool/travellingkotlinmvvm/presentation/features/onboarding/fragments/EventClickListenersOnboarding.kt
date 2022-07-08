package com.tokioschool.travellingkotlinmvvm.presentation.features.onboarding.fragments

import androidx.navigation.NavController
import com.tokioschool.travellingkotlinmvvm.R

class EventClickListenersOnboarding(private val navController: NavController) {

    fun navigateLogin(){
        navController.navigate(R.id.to_loginFragment)
    }
}