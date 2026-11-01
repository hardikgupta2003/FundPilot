package com.hardik.fundpilot.feature.dashboard.data.remote.service

import com.hardik.fundpilot.feature.dashboard.data.remote.api.DashboardApi
import com.hardik.fundpilot.feature.dashboard.data.remote.dto.MutualFundResponse
import retrofit2.Call
import javax.inject.Inject

class DashboardService @Inject constructor(val service : DashboardApi) : DashboardApi{

    override fun getMutualFunds(
        limit: Int,
        offset: Int
    ): Call<List<MutualFundResponse>> = service.getMutualFunds(limit,offset)

}