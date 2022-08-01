package com.tokioschool.travellingkotlinmvvm.core.di.presentation

import com.tokioschool.travellingkotlinmvvm.core.delegate.LoadingDelegate
import com.tokioschool.travellingkotlinmvvm.core.delegate.LoadingDelegateViewModel
import com.tokioschool.travellingkotlinmvvm.core.di.domain.di.IoDispatcher
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class PresentationModule {

    @Provides
    @Singleton
    fun provideEventsApp(@IoDispatcher workerScope: CoroutineScope): LoadingDelegateViewModel {
        return LoadingDelegate(workerScope)
    }
}
