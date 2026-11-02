package com.hardik.fundpilot.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.hardik.fundpilot.feature.dashboard.presentation.DashboardScreen
import com.hardik.fundpilot.feature.dashboard.presentation.DashboardViewModel
import com.hardik.fundpilot.feature.detail.FundDetailScreen
import com.hardik.fundpilot.feature.explore.ExploreScreen
import com.hardik.fundpilot.feature.watchlist.presentation.WatchlistScreen

/**
 * Navigation 3 Host equivalent.
 * Encapsulates NavDisplay and maps all routes (entryProvider) in a single modular composable.
 */
@Composable
fun FundPilotNavHost(
    navigator: FundPilotNavigator,
    dashboardViewModel: DashboardViewModel,
    modifier: Modifier = Modifier
) {
    NavDisplay(
        modifier = modifier,
        backStack = navigator.backStack.backStack,
        onBack = { navigator.goBack() },
        entryProvider = entryProvider {
            entry<FundPilotNavKey.Home> {
                DashboardScreen(
                    viewModel = dashboardViewModel,
                    onNavigateToDetail = { code, name ->
                        navigator.navigateTo(
                            FundPilotNavKey.FundDetail(schemeCode = code, schemeName = name)
                        )
                    }
                )
            }

            entry<FundPilotNavKey.Explore> {
                ExploreScreen(
                    onNavigateToDetail = { code, name ->
                        navigator.navigateTo(
                            FundPilotNavKey.FundDetail(schemeCode = code, schemeName = name)
                        )
                    }
                )
            }

            entry<FundPilotNavKey.Watchlist> {
                WatchlistScreen(
                    onNavigateToDetail = { code, name ->
                        navigator.navigateTo(
                            FundPilotNavKey.FundDetail(schemeCode = code, schemeName = name)
                        )
                    }
                )
            }

            entry<FundPilotNavKey.FundDetail> { key ->
                FundDetailScreen(
                    schemeCode = key.schemeCode,
                    schemeName = key.schemeName,
                    onBack = { navigator.goBack() }
                )
            }
        }
    )
}
