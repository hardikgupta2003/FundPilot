package com.hardik.fundpilot.core.di

import com.hardik.fundpilot.core.network.RetrofitClient
import com.hardik.fundpilot.feature.dashboard.data.remote.api.DashboardApi
import com.hardik.fundpilot.feature.dashboard.data.remote.service.DashboardService
import com.hardik.fundpilot.feature.dashboard.data.repository.DashboardRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DashboardModule {

    @Provides
    @Singleton
    fun provideDashboardApi(): DashboardApi {
        return RetrofitClient.getInstance().create(DashboardApi::class.java)
    }

}