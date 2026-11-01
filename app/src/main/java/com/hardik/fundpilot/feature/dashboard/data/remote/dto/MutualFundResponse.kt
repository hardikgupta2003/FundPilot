package com.hardik.fundpilot.feature.dashboard.data.remote.dto

import kotlinx.serialization.Serializable


@Serializable
data class MutualFundResponse(
    val schemeCode: String,
    val schemeName: String,
    val isInGrowth: String,
    val isinDivReinvestment: String
)