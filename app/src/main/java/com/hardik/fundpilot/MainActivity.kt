package com.hardik.fundpilot

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.hardik.fundpilot.feature.dashboard.presentation.DashboardViewModel
import com.hardik.fundpilot.navigation.FundPilotNavHost
import com.hardik.fundpilot.navigation.FundPilotNavKey
import com.hardik.fundpilot.navigation.rememberFundPilotNavigator
import com.hardik.fundpilot.ui.components.FundPilotBottomNavBar
import com.hardik.fundpilot.ui.theme.FundPilotTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val dashboardViewModel: DashboardViewModel by viewModels()
        enableEdgeToEdge()

        setContent {
            FundPilotTheme {
                FundPilotAppContent(dashboardViewModel)
            }
        }
    }
}

@Composable
fun FundPilotAppContent(dashboardViewModel: DashboardViewModel) {
    val navigator = rememberFundPilotNavigator()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            if (navigator.isTopLevel) {
                FundPilotBottomNavBar(
                    selectedRoute = navigator.currentTabTitle,
                    onRouteSelected = { route ->
                        when (route) {
                            "Home" -> navigator.navigateToTopLevel(FundPilotNavKey.Home)
                            "Explore" -> navigator.navigateToTopLevel(FundPilotNavKey.Explore)
                            "Watchlist" -> navigator.navigateToTopLevel(FundPilotNavKey.Watchlist)
                        }
                    }
                )
            }
        }
    ) { innerPadding ->
        FundPilotNavHost(
            navigator = navigator,
            dashboardViewModel = dashboardViewModel,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        )
    }
}
