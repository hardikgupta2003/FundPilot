package com.hardik.fundpilot.feature.dashboard.data.repository

import com.google.gson.Gson
import com.hardik.fundpilot.core.network.NetworkError
import com.hardik.fundpilot.core.network.ResponseResult
import com.hardik.fundpilot.feature.dashboard.data.remote.dto.MutualFundsResponse
import com.hardik.fundpilot.feature.dashboard.data.remote.service.DashboardService
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class DashboardRepository @Inject constructor(private val dashboardService: DashboardService) {

    fun getMutualFunds(limit: Int, offset: Int): Flow<ResponseResult<MutualFundsResponse>> {
        return flow {
            emit(ResponseResult.Loading)
            try {
                val result = dashboardService.getMutualFunds(limit, offset).execute()
                if (result.isSuccessful) {
                    val body = result.body()
                    if (body != null) {
                        val response =
                            Gson().fromJson(body.toString(), MutualFundsResponse::class.java)
                        emit(ResponseResult.Success(data = response))
                    }
                } else {
                    emit(
                        ResponseResult.Error(
                            error = NetworkError.Network(
                                result.code(),
                                result.message()
                            )
                        )
                    )
                }
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                emit(ResponseResult.Error(error = NetworkError.Http(e.message.toString())))
            }
        }.flowOn(Dispatchers.IO)
    }
}
