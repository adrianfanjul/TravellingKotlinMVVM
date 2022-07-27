package com.tokioschool.travellingkotlinmvvm.core.di.data


import com.tokioschool.travellingkotlinmvvm.data.repository.LoginRepositoryImpl
import com.tokioschool.travellingkotlinmvvm.domain.repository.LoginRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModules {
    @Binds
    abstract fun bindingLoginRepository(loginRepositoryImpl: LoginRepositoryImpl): LoginRepository

}