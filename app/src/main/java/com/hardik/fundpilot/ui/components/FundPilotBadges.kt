package com.hardik.fundpilot.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hardik.fundpilot.ui.theme.FundPilotTheme
import com.hardik.fundpilot.ui.theme.LocalExtendedFinancialColors

/**
 * Return Percentage Status Badge (e.g. ↑ +18.4% or ↓ -2.1%).
 */
@Composable
fun FundPilotReturnBadge(
    returnPercentage: Double,
    modifier: Modifier = Modifier
) {
    val isPositive = returnPercentage >= 0
    val financialColors = LocalExtendedFinancialColors.current

    val backgroundColor = if (isPositive) financialColors.gainPositiveContainer else financialColors.lossNegativeContainer
    val textColor = if (isPositive) financialColors.gainPositive else financialColors.lossNegative
    val symbol = if (isPositive) "↑ +" else "↓ "

    Surface(
        modifier = modifier,
        shape = CircleShape,
        color = backgroundColor
    ) {
        Row(
            modifier = Modifier
                .height(26.dp)
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "$symbol${String.format(java.util.Locale.US, "%.2f", returnPercentage)}%",
                style = MaterialTheme.typography.labelMedium,
                fontWeight = FontWeight.Bold,
                color = textColor
            )
        }
    }
}

/**
 * Riskometer Indicator Badge (e.g. Very High Risk, Moderate Risk).
 */
@Composable
fun FundPilotRiskBadge(
    riskLevel: String,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(6.dp),
        color = MaterialTheme.colorScheme.surfaceContainerHighest
    ) {
        Row(
            modifier = Modifier
                .height(24.dp)
                .padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = riskLevel,
                style = MaterialTheme.typography.labelSmall,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Preview(name = "Light Mode", showBackground = true)
@Preview(name = "Dark Mode", uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun FundPilotBadgesPreview() {
    FundPilotTheme {
        androidx.compose.foundation.layout.Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                FundPilotReturnBadge(returnPercentage = 18.45)
                FundPilotReturnBadge(returnPercentage = -2.10)
            }
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                FundPilotRiskBadge(riskLevel = "Very High Risk")
                FundPilotRiskBadge(riskLevel = "Moderate Risk")
            }
        }
    }
}
