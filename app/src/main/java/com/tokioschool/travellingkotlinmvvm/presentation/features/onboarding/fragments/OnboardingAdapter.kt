package com.tokioschool.travellingkotlinmvvm.presentation.features.onboarding.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class OnboardingAdapter(fragment: FragmentManager, lefecycle: Lifecycle):FragmentStateAdapter(fragment,lefecycle){
    override fun getItemCount(): Int=3

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> OnboardingStepOneFragment()
            1 -> OnboardingStepTwoFragment()
            2 -> OnboardingStepThreeFragment()
            else -> throw IllegalAccessException("no step found")
        }
    }

}