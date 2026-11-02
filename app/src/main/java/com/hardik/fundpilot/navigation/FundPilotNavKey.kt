package com.hardik.fundpilot.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface FundPilotNavKey : NavKey {

    @Serializable
    data object Home : FundPilotNavKey

    @Serializable
    data object Explore : FundPilotNavKey

    @Serializable
    data object Watchlist : FundPilotNavKey

    @Serializable
    data class FundDetail(
        val schemeCode: String,
        val schemeName: String = ""
    ) : FundPilotNavKey
}
