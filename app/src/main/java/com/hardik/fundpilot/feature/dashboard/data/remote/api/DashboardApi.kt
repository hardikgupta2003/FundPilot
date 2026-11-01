package com.hardik.fundpilot.feature.dashboard.data.remote.api

import com.hardik.fundpilot.feature.dashboard.data.remote.dto.MutualFundResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DashboardApi {

    @GET("/mf")
    fun getMutualFunds(
        @Query("limit") limit : Int,
        @Query("offset") offset : Int,
    ) : Call<List<MutualFundResponse>>
}