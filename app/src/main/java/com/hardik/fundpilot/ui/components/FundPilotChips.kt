package com.hardik.fundpilot.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hardik.fundpilot.ui.theme.EmeraldPrimaryContainer
import com.hardik.fundpilot.ui.theme.FundPilotTheme

private val CheckIcon: ImageVector by lazy {
    ImageVector.Builder(
        name = "Check",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f
    ).apply {
        path(
            fill = null,
            stroke = SolidColor(Color.Black),
            strokeLineWidth = 2.5f,
            strokeLineCap = StrokeCap.Round,
            strokeLineJoin = StrokeJoin.Round,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(20f, 6f)
            lineTo(9f, 17f)
            lineTo(4f, 12f)
        }
    }.build()
}

/**
 * Filter Chip matching M3 Stitch Spec.
 * Selected: Background `#E6F4EA`, Border `#087F5B`, leading check icon.
 * Unselected: Background Surface, Border Outline.
 */
@Composable
fun FundPilotFilterChip(
    selected: Boolean,
    onClick: () -> Unit,
    label: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    FilterChip(
        selected = selected,
        onClick = onClick,
        label = {
            Text(
                text = label,
                style = MaterialTheme.typography.bodySmall,
                fontWeight = if (selected) FontWeight.SemiBold else FontWeight.Medium
            )
        },
        modifier = modifier.height(36.dp),
        enabled = enabled,
        leadingIcon = if (selected) {
            {
                Icon(
                    imageVector = CheckIcon,
                    contentDescription = "Selected",
                    modifier = Modifier.size(16.dp),
                    tint = EmeraldPrimaryContainer
                )
            }
        } else null,
        shape = CircleShape,
        colors = FilterChipDefaults.filterChipColors(
            containerColor = MaterialTheme.colorScheme.surface,
            labelColor = MaterialTheme.colorScheme.onSurfaceVariant,
            selectedContainerColor = EmeraldPrimaryContainer.copy(alpha = 0.15f),
            selectedLabelColor = EmeraldPrimaryContainer
        ),
        border = FilterChipDefaults.filterChipBorder(
            enabled = enabled,
            selected = selected,
            borderColor = MaterialTheme.colorScheme.outlineVariant,
            selectedBorderColor = EmeraldPrimaryContainer,
            borderWidth = 1.dp,
            selectedBorderWidth = 1.dp
        )
    )
}

/**
 * Horizontal Row of single-choice options (e.g. 1Y, 3Y, 5Y, MAX).
 */
@Composable
fun FundPilotSingleChoiceChipGroup(
    options: List<String>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 4.dp)
    ) {
        items(options) { option ->
            FundPilotFilterChip(
                selected = option == selectedOption,
                onClick = { onOptionSelected(option) },
                label = option
            )
        }
    }
}

/**
 * Category Badge Pill (e.g. Equity • Mid Cap).
 */
@Composable
fun FundPilotCategoryTag(
    text: String,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        shape = CircleShape,
        color = MaterialTheme.colorScheme.surfaceContainerHigh,
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
    ) {
        Row(
            modifier = Modifier.height(28.dp).padding(horizontal = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Preview(name = "Light Mode", showBackground = true)
@Preview(name = "Dark Mode", uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun FundPilotChipsPreview() {
    FundPilotTheme {
        androidx.compose.foundation.layout.Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                FundPilotFilterChip(selected = true, onClick = {}, label = "Large Cap")
                FundPilotFilterChip(selected = false, onClick = {}, label = "Flexi Cap")
            }
            FundPilotSingleChoiceChipGroup(
                options = listOf("1Y", "3Y", "5Y", "MAX"),
                selectedOption = "3Y",
                onOptionSelected = {}
            )
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                FundPilotCategoryTag(text = "Equity • Mid Cap")
                FundPilotCategoryTag(text = "Very High Risk")
            }
        }
    }
}
