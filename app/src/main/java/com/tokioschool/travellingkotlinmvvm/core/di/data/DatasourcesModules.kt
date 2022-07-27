package com.tokioschool.travellingkotlinmvvm.core.di.data

import com.tokioschool.travellingkotlinmvvm.data.datasource.HotelsDatasource
import com.tokioschool.travellingkotlinmvvm.data.datasource.LoginDatasource
import com.tokioschool.travellingkotlinmvvm.data.datasource.WeatherDatasource
import com.tokioschool.travellingkotlinmvvm.data.datasource.impl.HotelsDatasourceImpl
import com.tokioschool.travellingkotlinmvvm.data.datasource.impl.LoginDatasourceImpl
import com.tokioschool.travellingkotlinmvvm.data.datasource.impl.WeatherDatasourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class DatasourcesModules {

    @Binds
    abstract fun bindingLoginDataSource(loginDatasourceImpl: LoginDatasourceImpl): LoginDatasource

    @Binds
    abstract fun bindingHotelsDataSource(impl: HotelsDatasourceImpl): HotelsDatasource

    @Binds
    abstract fun bindingWeatherDataSource(impl: WeatherDatasourceImpl): WeatherDatasource
}