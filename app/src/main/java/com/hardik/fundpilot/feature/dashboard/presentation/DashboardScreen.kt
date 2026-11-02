package com.hardik.fundpilot.feature.dashboard.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun DashboardScreen(viewModel : DashboardViewModel, onNavigateToDetail : (String, String) -> Unit){

    Box(modifier = Modifier.size(50.dp), contentAlignment = Alignment.Center){
        Text(text = "Dashboard", modifier = Modifier.clickable{
            viewModel.getMutualFunds(50,0)
        })
    }



}