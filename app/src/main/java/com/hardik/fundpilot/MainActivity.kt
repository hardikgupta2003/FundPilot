package com.hardik.fundpilot

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.hardik.fundpilot.feature.dashboard.presentation.DashboardScreen
import com.hardik.fundpilot.feature.dashboard.presentation.DashboardViewModel
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
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(
                        modifier = Modifier.padding(innerPadding)
                    ){
                        DashboardScreen(dashboardViewModel)
                    }
                }
            }
        }
    }
}

