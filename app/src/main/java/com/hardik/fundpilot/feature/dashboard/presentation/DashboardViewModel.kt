package com.hardik.fundpilot.feature.dashboard.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hardik.fundpilot.feature.dashboard.data.repository.DashboardRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(private val repository : DashboardRepository) : ViewModel() {

    fun getMutualFunds(limit: Int, offset: Int){
        viewModelScope.launch {
            repository.getMutualFunds(limit,offset).collect {
it.toString()
            }
        }
    }
}