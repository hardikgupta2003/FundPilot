package com.hardik.fundpilot.feature.explore

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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.hardik.fundpilot.ui.components.FundPilotFilterChip
import com.hardik.fundpilot.ui.components.FundPilotReturnBadge
import com.hardik.fundpilot.ui.components.FundPilotSearchBar

data class ExploreFundItem(
    val code: String,
    val name: String,
    val category: String,
    val returns3Y: Double
)

val sampleExploreFunds = listOf(
    ExploreFundItem("120503", "HDFC Mid-Cap Opportunities Fund", "Mid Cap", 26.4),
    ExploreFundItem("119598", "Nippon India Small Cap Fund", "Small Cap", 31.8),
    ExploreFundItem("118989", "Parag Parikh Flexi Cap Fund", "Flexi Cap", 22.1),
    ExploreFundItem("120716", "Mirae Asset Large Cap Fund", "Large Cap", 18.5),
    ExploreFundItem("100027", "Grindlays Super Saver Income Fund", "Debt", 7.8)
)

val categories = listOf("All", "Large Cap", "Mid Cap", "Small Cap", "Flexi Cap", "Debt")

@Composable
fun ExploreScreen(
    onNavigateToDetail: (schemeCode: String, schemeName: String) -> Unit,
    modifier: Modifier = Modifier
) {

}
