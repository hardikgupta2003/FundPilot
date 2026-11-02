package com.hardik.fundpilot.feature.watchlist.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.hardik.fundpilot.ui.components.FundPilotReturnBadge

data class WatchlistFund(
    val code: String,
    val name: String,
    val nav: String,
    val returns1Y: Double
)

val sampleWatchlist = listOf(
    WatchlistFund("119598", "Nippon India Small Cap Fund", "₹ 156.40", 34.2),
    WatchlistFund("120503", "HDFC Mid-Cap Opportunities Fund", "₹ 178.10", 28.5),
    WatchlistFund("118989", "Parag Parikh Flexi Cap Fund", "₹ 82.30", 21.7)
)

@Composable
fun WatchlistScreen(
    onNavigateToDetail: (schemeCode: String, schemeName: String) -> Unit,
    modifier: Modifier = Modifier
) {

}
