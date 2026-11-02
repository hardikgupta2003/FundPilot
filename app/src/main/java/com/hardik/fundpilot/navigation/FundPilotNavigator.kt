package com.hardik.fundpilot.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

/**
 * Navigation 3 Controller equivalent (Navigator).
 * Provides clean navigation actions (navigate, navigateToTopLevel, goBack).
 */
class FundPilotNavigator(val backStack: TopLevelBackStack<FundPilotNavKey>) {

    val currentDestination: FundPilotNavKey
        get() = backStack.backStack.lastOrNull() ?: FundPilotNavKey.Home

    val isTopLevel: Boolean
        get() = currentDestination is FundPilotNavKey.Home ||
                currentDestination is FundPilotNavKey.Explore ||
                currentDestination is FundPilotNavKey.Watchlist

    val currentTabTitle: String
        get() = when (backStack.topLevelKey) {
            FundPilotNavKey.Home -> "Home"
            FundPilotNavKey.Explore -> "Explore"
            FundPilotNavKey.Watchlist -> "Watchlist"
            else -> "Home"
        }

    fun navigateToTopLevel(route: FundPilotNavKey) {
        backStack.addTopLevel(route)
    }

    fun navigateTo(route: FundPilotNavKey) {
        backStack.add(route)
    }

    fun goBack() {
        backStack.removeLast()
    }
}

@Composable
fun rememberFundPilotNavigator(
    startDestination: FundPilotNavKey = FundPilotNavKey.Home
): FundPilotNavigator {
    val backStack = remember { TopLevelBackStack(startDestination) }
    return remember(backStack) { FundPilotNavigator(backStack) }
}
